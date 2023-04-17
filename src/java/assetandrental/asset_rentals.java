package assetandrental;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.text.Position;

// products data access object
public class asset_rentals {

    public int asset_id;
    public String rental_date;
    public String reservation_date;
    public int resident_id;
    public Double rental_amount;
    public Double discount;
    public String status;
    public String inspection_details;
    public Double assessed_value;
    public int accept_hoid;
    public String accept_position;
    public String accept_electiondate;
    public String return_date;

    ArrayList<Integer> asset_idlist = new ArrayList<>();
    ArrayList<Integer> resident_idlist = new ArrayList<>();
    ArrayList<Integer> accept_hoidlist = new ArrayList<>();

    public asset_rentals() {
    }; // Constructor of the DAO

    public int addRecord() { // Method add a Record
        try {
            // 1. Instantiate a connection variable
            Connection conn;
            // 2. Connect to your DB
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            // 3. Indicate a notice of successful connection
            System.out.println("Connection Successful");
            // clear lists
            asset_idlist.clear();
            resident_idlist.clear();
            accept_hoidlist.clear();
            // drop down
            PreparedStatement pstmt = conn.prepareStatement("SELECT asset_id FROM assets WHERE forrent=1");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                asset_id = rs.getInt("asset_id");
                asset_idlist.add(asset_id);
            }
            pstmt = conn.prepareStatement("SELECT resident_id FROM residents");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                resident_id = rs.getInt("resident_id");
                resident_idlist.add(resident_id);
            }

            pstmt = conn.prepareStatement("SELECT ho_id FROM officer");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                accept_hoid = rs.getInt("ho_id");
                accept_hoidlist.add(accept_hoid);
            }
            // get data related to the specific officer
            pstmt = conn.prepareStatement("SELECT position, election_date FROM officer WHERE ho_id=?");
            pstmt.setInt(1, accept_hoid);
            rs = pstmt.executeQuery();
            while (rs.next()) { // get values considered with the chosen officer
                accept_position = rs.getString("position");
                accept_electiondate = rs.getString("election_date");
            }

            // 4. Prepare our INSERT Statement
            pstmt = conn.prepareStatement("INSERT INTO asset_rentals VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            // 5. Supply the statement with values
            int x = 0;

            if ((accept_hoid == 0 ||
                    "".equals(accept_position) ||
                    "".equals(accept_electiondate)) &&
                    !"".equals(return_date)) {
                pstmt = conn.prepareStatement("INSERT INTO asset_rentals VALUES (?,?,?,?,?,?,?,?,?,null,null,null,?)");
                x = 3;
            } else if ((accept_hoid != 0 ||
                    !"".equals(accept_position) ||
                    !"".equals(accept_electiondate)) &&
                    "".equals(return_date)) {
                pstmt = conn.prepareStatement("INSERT INTO asset_rentals VALUES (?,?,?,?,?,?,?,?,?,?,?,?,null)");
            } else if ((accept_hoid == 0 ||
                    "".equals(accept_position) ||
                    "".equals(accept_electiondate)) &&
                    "".equals(return_date)) {
                pstmt = conn
                        .prepareStatement("INSERT INTO asset_rentals VALUES (?,?,?,?,?,?,?,?,?,null,null,null,null)");
            }

            pstmt.setInt(1, asset_id);
            pstmt.setString(2, rental_date);
            pstmt.setString(3, reservation_date);
            pstmt.setInt(4, resident_id);
            pstmt.setDouble(5, rental_amount);
            pstmt.setDouble(6, discount);
            pstmt.setString(7, status);
            pstmt.setString(8, inspection_details);
            pstmt.setDouble(9, assessed_value);
            if (accept_hoid != 0 &&
                    !"".equals(accept_position) &&
                    !"".equals(accept_electiondate)) {
                pstmt.setInt(10, accept_hoid);
                pstmt.setString(11, accept_position);
                pstmt.setString(12, accept_electiondate);
            }
            if (!"".equals(return_date)) {
                pstmt.setString(13 - x, return_date);
            }

            // 6. Execute the SQL Statement
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int retRecord() { // Method dispose a Record
        try {
            // 1. Instantiate a connection variable
            Connection conn;
            // 2. Connect to your DB
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            // 3. Indicate a notice of successful connection
            System.out.println("Connection Successful");
            // 4. Prepare our INSERT Statement
            PreparedStatement pstmt = conn.prepareStatement(
                    "UPDATE asset_rentals SET return_date = ? WHERE asset_id = ? AND rental_date = ?");
            // 5. Supply the statement with values
            int x = 0;
            if (return_date == "") {
                pstmt = conn.prepareStatement(
                        "UPDATE asset_rentals SET return_date = null WHERE asset_id = ? AND rental_date = ?");
                x = 1;
            } else {
                pstmt.setString(1, return_date);
            }
            pstmt.setInt(2 - x, asset_id);
            pstmt.setString(3 - x, rental_date);

            // 6. Execute the SQL Statement
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int delRecord() { // Method mark a Record as deleted
        try {
            // 1. Instantiate a connection variable
            Connection conn;
            // 2. Connect to your DB
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            // 3. Indicate a notice of successful connection
            System.out.println("Connection Successful");
            // 4. Prepare our INSERT Statement
            PreparedStatement pstmt = conn
                    .prepareStatement("UPDATE asset_rentals SET status = \'C\', inspection_details = \'DELETED\'" +
                            "WHERE asset_id = ? AND rental_date = ? AND accept_position = \'president\' ");
            // 5. Supply the statement with values
            pstmt.setInt(1, asset_id);
            pstmt.setString(2, rental_date);

            // 6. Execute the SQL Statement
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int updateRecord() { // Method modify a Record
        try {
            // 1. Instantiate a connection variable
            Connection conn;
            // 2. Connect to your DB
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            // 3. Indicate a notice of successful connection
            System.out.println("Connection Successful");
            // 4. Prepare our INSERT Statement
            PreparedStatement pstmt = conn.prepareStatement("UPDATE asset_rentals    " +
                    "SET    reservation_date = ?,       " +
                    "       resident_id = ?,       " +
                    "       rental_amount = ?,       " +
                    "       discount = ?,       " +
                    "       status = ?,       " +
                    "       inspection_details = ?,       " +
                    "       assessed_value = ?,       " +
                    "       accept_hoid = ?,       " +
                    "       accept_position = ?,       " +
                    "       accept_electiondate = ?,       " +
                    "       return_date = ?       " +
                    "WHERE asset_id = ? AND rental_date = ?");
            // 5. Supply the statement with values
            int x = 0;

            if ((accept_hoid == 0 ||
                    "".equals(accept_position) ||
                    "".equals(accept_electiondate)) &&
                    !"".equals(return_date)) {
                pstmt = conn.prepareStatement("UPDATE asset_rentals    " +
                        "SET    reservation_date = ?,       " +
                        "       resident_id = ?,       " +
                        "       rental_amount = ?,       " +
                        "       discount = ?,       " +
                        "       status = ?,       " +
                        "       inspection_details = ?,       " +
                        "       assessed_value = ?,       " +
                        "       accept_hoid = null,       " +
                        "       accept_position = null,       " +
                        "       accept_electiondate = null,       " +
                        "       return_date = ?       " +
                        "WHERE asset_id = ? AND rental_date = ?");
                x = 3;
            } else if ((accept_hoid != 0 ||
                    !"".equals(accept_position) ||
                    !"".equals(accept_electiondate)) &&
                    "".equals(return_date)) {
                pstmt = conn.prepareStatement("UPDATE asset_rentals    " +
                        "SET    reservation_date = ?,       " +
                        "       resident_id = ?,       " +
                        "       rental_amount = ?,       " +
                        "       discount = ?,       " +
                        "       status = ?,       " +
                        "       inspection_details = ?,       " +
                        "       assessed_value = ?,       " +
                        "       accept_hoid = ?,       " +
                        "       accept_position = ?,       " +
                        "       accept_electiondate = ?,       " +
                        "       return_date = null       " +
                        "WHERE asset_id = ? AND rental_date = ?");
                x = 1;
            } else if ((accept_hoid == 0 ||
                    "".equals(accept_position) ||
                    "".equals(accept_electiondate)) &&
                    "".equals(return_date)) {
                pstmt = conn.prepareStatement("UPDATE asset_rentals    " +
                        "SET    reservation_date = ?,       " +
                        "       resident_id = ?,       " +
                        "       rental_amount = ?,       " +
                        "       discount = ?,       " +
                        "       status = ?,       " +
                        "       inspection_details = ?,       " +
                        "       assessed_value = ?,       " +
                        "       accept_hoid = null,       " +
                        "       accept_position = null,       " +
                        "       accept_electiondate = null,       " +
                        "       return_date = null       " +
                        "WHERE asset_id = ? AND rental_date = ?");
                x = 4;
            }

            pstmt.setString(1, reservation_date);
            pstmt.setInt(2, resident_id);
            pstmt.setDouble(3, rental_amount);
            pstmt.setDouble(4, discount);
            pstmt.setString(5, status);
            pstmt.setString(6, inspection_details);
            pstmt.setDouble(7, assessed_value);
            if (accept_hoid != 0 &&
                    !"".equals(accept_position) &&
                    !"".equals(accept_electiondate)) {
                pstmt.setInt(8, accept_hoid);
                pstmt.setString(9, accept_position);
                pstmt.setString(10, accept_electiondate);
            }
            if (!"".equals(return_date)) {
                pstmt.setString(11 - x, return_date);
            }
            pstmt.setInt(12 - x, asset_id);
            pstmt.setString(13 - x, rental_date);

            // 6. Execute the SQL Statement
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public static void main(String[] args) {
        asset_rentals r = new asset_rentals();
        r.asset_id = 5012;
        r.rental_date = "2022-08-04";
        r.reservation_date = "2022-08-04";
        r.resident_id = 9002;
        r.rental_amount = 50.00;
        r.discount = 0.00;
        r.status = "N";
        r.accept_hoid = 9001;
        r.inspection_details = "";
        r.assessed_value = 50.50;
        r.accept_position = "president";
        r.accept_electiondate = "2022-06-01";
        r.return_date = "";

        r.updateRecord();
    }
}
