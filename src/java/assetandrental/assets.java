package assetandrental;

import java.sql.*;
import java.util.*;

// products data access object
public class assets {

    public int asset_id;
    public String asset_name;
    public String asset_description;
    public String acquisition_date;
    public Boolean forrent;
    public double asset_value;
    public String type_asset;
    public String status;
    public double loc_lattitude;
    public double loc_longitude;
    public String hoa_name;
    public Integer enclosing_asset;

    public ArrayList<Integer> asset_idlist = new ArrayList<>();
    public ArrayList<String> asset_namelist = new ArrayList<>();
    public ArrayList<String> asset_descriptionlist = new ArrayList<>();
    public ArrayList<String> acquisition_datelist = new ArrayList<>();
    public ArrayList<Boolean> forrentlist = new ArrayList<>();
    public ArrayList<Double> asset_valuelist = new ArrayList<>();
    public ArrayList<String> type_assetlist = new ArrayList<>();
    public ArrayList<String> statuslist = new ArrayList<>();
    public ArrayList<Double> loc_lattitudelist = new ArrayList<>();
    public ArrayList<Double> loc_longiturelist = new ArrayList<>();
    public ArrayList<String> hoa_namelist = new ArrayList<>();
    public ArrayList<Integer> enclosing_assetlist = new ArrayList<>();

    public assets() {
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
            // 3.5 Clearing Array Lists
            asset_idlist.clear();
            asset_namelist.clear();
            asset_descriptionlist.clear();
            acquisition_datelist.clear();
            forrentlist.clear();
            asset_valuelist.clear();
            type_assetlist.clear();
            statuslist.clear();
            loc_lattitudelist.clear();
            loc_longiturelist.clear();
            hoa_namelist.clear();
            enclosing_assetlist.clear();
            // 4. Drop-Down Lists
            PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(asset_id) + 1 AS newID FROM assets");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                asset_id = rs.getInt("newID");
            }
            // for dropdown list
            pstmt = conn.prepareStatement("SELECT hoa_name AS association_name FROM hoa");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                hoa_name = rs.getString("association_name");
                hoa_namelist.add(hoa_name);
            }
            // dropdown list 2
            pstmt = conn.prepareStatement("SELECT asset_id as enclosing_ID from assets WHERE type_asset = 'P'");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                enclosing_asset = rs.getInt("enclosing_ID");
                enclosing_assetlist.add(enclosing_asset);
            }
            // 4.5 Prepare our INSERT Statement
            pstmt = conn.prepareStatement("INSERT INTO assets VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            // 5. Supply the statement with values

            pstmt.setInt(1, asset_id);
            pstmt.setString(2, asset_name);
            pstmt.setString(3, asset_description);
            pstmt.setString(4, acquisition_date);
            pstmt.setBoolean(5, forrent);
            pstmt.setDouble(6, asset_value);
            pstmt.setString(7, type_asset);
            pstmt.setString(8, status);
            pstmt.setDouble(9, loc_lattitude);
            pstmt.setDouble(10, loc_longitude);
            pstmt.setString(11, hoa_name);
            if (enclosing_asset == 0) {
                pstmt.setNull(12, enclosing_asset);
            } else {
                pstmt.setInt(12, enclosing_asset);
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

    public int dispRecord() { // Method dispose a Record
        try {
            // 1. Instantiate a connection variable
            Connection conn;
            // 2. Connect to your DB
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            // 3. Indicate a notice of successful connection
            System.out.println("Connection Successful");
            // 3.5 Clearing Array Lists
            asset_idlist.clear();
            asset_namelist.clear();
            asset_descriptionlist.clear();
            acquisition_datelist.clear();
            forrentlist.clear();
            asset_valuelist.clear();
            type_assetlist.clear();
            statuslist.clear();
            loc_lattitudelist.clear();
            loc_longiturelist.clear();
            hoa_namelist.clear();
            enclosing_assetlist.clear();
            // 4. Drop-Down Lists
            PreparedStatement pstmt = conn.prepareStatement("SELECT asset_id AS ID_of_assets FROM assets");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                asset_id = rs.getInt("ID_of_assets");
                asset_idlist.add(asset_id);
            }
            // 4. Prepare our INSERT Statement
            pstmt = conn.prepareStatement("UPDATE assets SET status = ? WHERE asset_id = ?");
            // 5. Supply the statement with values
            pstmt.setString(1, "X");
            pstmt.setInt(2, asset_id);

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
            // clear arraylists
            asset_idlist.clear();
            asset_namelist.clear();
            asset_descriptionlist.clear();
            acquisition_datelist.clear();
            forrentlist.clear();
            asset_valuelist.clear();
            type_assetlist.clear();
            statuslist.clear();
            loc_lattitudelist.clear();
            loc_longiturelist.clear();
            hoa_namelist.clear();
            enclosing_assetlist.clear();
            // build dropdowns
            PreparedStatement pstmt = conn.prepareStatement("SELECT asset_id FROM assets WHERE status !='X'");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) { // asset dropdown
                asset_id = rs.getInt("asset_id");
                asset_idlist.add(asset_id);
            }
            pstmt = conn.prepareStatement("SELECT hoa_name AS association_name FROM hoa");
            rs = pstmt.executeQuery();
            while (rs.next()) { // association dropdown
                hoa_name = rs.getString("association_name");
                hoa_namelist.add(hoa_name);
            }
            // dropdown list 2
            pstmt = conn.prepareStatement("SELECT asset_id as enclosing_ID from assets WHERE type_asset = 'P'");
            rs = pstmt.executeQuery();
            while (rs.next()) {// enlcosing_asset dropdown
                enclosing_asset = rs.getInt("enclosing_ID");
                enclosing_assetlist.add(enclosing_asset);
            }

            // get original row data
            pstmt = conn.prepareStatement("SELECT * FROM assets WHERE asset_id=?");
            pstmt.setInt(1, asset_id);
            // 4. Prepare our INSERT Statement
            pstmt = conn.prepareStatement("UPDATE assets    " +
                    "SET    asset_name   = ?,      " +
                    "       asset_description = ?,       " +
                    "       acquisition_date = ?,       " +
                    "       forrent = ?,       " +
                    "       asset_value = ?,       " +
                    "       type_asset = ?,       " +
                    "       status = ?,       " +
                    "       loc_lattitude = ?,       " +
                    "       loc_longiture = ?,       " +
                    "       hoa_name = ?,       " +
                    "       enclosing_asset = ?       " +
                    "WHERE  asset_id = ? ");
            // 5. Supply the statement with values
            pstmt.setString(1, asset_name);
            pstmt.setString(2, asset_description);
            pstmt.setString(3, acquisition_date);
            pstmt.setBoolean(4, forrent);
            pstmt.setDouble(5, asset_value);
            pstmt.setString(6, type_asset);
            pstmt.setString(7, status);
            pstmt.setDouble(8, loc_lattitude);
            pstmt.setDouble(9, loc_longitude);
            pstmt.setString(10, hoa_name);
            pstmt.setNull(11, enclosing_asset);
            pstmt.setInt(12, asset_id);

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

    public int delRecord() { // Method delete a Record
        try {
            // 1. Instantiate a connection variable
            Connection conn;
            // 2. Connect to your DB
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            // 3. Indicate a notice of successful connection
            System.out.println("Connection Successful");
            // 4. Prepare our INSERT Statement and remove from enclosing asset
            PreparedStatement pstmt = conn.prepareStatement("SELECT enclosing_asset FROM assets WHERE asset_id=?");
            pstmt.setInt(1, asset_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                enclosing_asset = rs.getInt("enclosing_asset");
            }

            if (enclosing_asset != null) {
                pstmt = conn.prepareStatement("UPDATE assets SET enclosing_asset = ? WHERE asset_id = ? ");
                pstmt.setNull(1, enclosing_asset);
                pstmt.setInt(2, asset_id);
            }

            // 5. Supply the statement with values
            pstmt = conn.prepareStatement("DELETE FROM assets WHERE asset_id=?");
            pstmt.setInt(1, asset_id);
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

    public int viewRecord() { // Method viewing a - Getting something
        try {
            // 1. Instantiate a connection variable
            Connection conn;
            // 2. Connect to your DB
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            // 3. Indicate a notice of successful connection
            System.out.println("Connection Successful");
            // 4. Prepare our INSERT Statement
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM assets WHERE asset_id=?");
            // 5. Supply the statement with values
            pstmt.setInt(1, asset_id);
            // 6. Execute the SQL Statement
            ResultSet rs = pstmt.executeQuery();

            // 7. Get the results
            while (rs.next()) {
                asset_id = rs.getInt("asset_id");
                asset_name = rs.getString("asset_name");
                asset_description = rs.getString("asset_description");
                acquisition_date = rs.getString("acquisition_date");
                forrent = rs.getBoolean("forrent");
                asset_value = rs.getFloat("asset_value");
                type_asset = rs.getString("type_asset");
                status = rs.getString("status");
                loc_lattitude = rs.getFloat("loc_lattitude");
                loc_longitude = rs.getFloat("loc_longitude");
                hoa_name = rs.getString("hoa_name");
                enclosing_asset = rs.getInt("enclosing_asset");
            }
            rs.close();
            pstmt.close();
            conn.close();

            return 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public static void main(String[] args) {

    }
}
