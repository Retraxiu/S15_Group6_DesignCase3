package assetandrental;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class handler {

   public int cancelOrder() {
      try {
         Connection conn;
         conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
         PreparedStatement pstmt = conn.prepareStatement("DELETE FROM assets WHERE asset_id = ?");
         pstmt.executeUpdate();
         pstmt.close();
         conn.close();
         return 1;
      } catch (Exception e) {
         System.out.println(e.getMessage());
         return 0;
      }
   }

   public int newOrder(int id,
         String name,
         String desc,
         String date,
         Boolean rent,
         Double value,
         String type,
         String status,
         Double lattitude,
         Double longitude,
         String HOAname,
         Integer enclosedby) {
      assets a = new assets();

      a.asset_id = id;
      a.asset_name = name;
      a.asset_description = desc;
      a.acquisition_date = date;
      a.forrent = true;
      a.asset_value = value;
      a.type_asset = type;
      a.status = status;
      a.loc_lattitude = lattitude;
      a.loc_longitude = longitude;
      a.hoa_name = HOAname;
      a.enclosing_asset = enclosedby;

      // A record will fail to be added if there is a single incorrect parameter input
      // Ex. duplicated id, non-existent enclosing asset, non-existent hoa name

      a.addRecord();

      return 0;
   }

   public int newOrder_r(int asset_id,
         String rental_date,
         String reservation_date,
         int resident_id,
         Double rental_amount,
         Double discount,
         String status,
         String inspection_details,
         Double assessed_value,
         int accept_hoid,
         String accept_position,
         String accept_electiondate,
         String return_date) {

      asset_rentals r = new asset_rentals();

      r.asset_id = asset_id;
      r.rental_date = rental_date;
      r.reservation_date = reservation_date;
      r.resident_id = resident_id;
      r.rental_amount = rental_amount;
      r.discount = discount;
      r.status = status;
      r.inspection_details = inspection_details;
      r.assessed_value = assessed_value;
      r.accept_hoid = accept_hoid;
      r.accept_position = accept_position;
      r.accept_electiondate = accept_electiondate;
      r.return_date = return_date;

      r.addRecord();

      return 0;
   }

   public int updateOrder(int id,
         String name,
         String desc,
         String date,
         Boolean rent,
         Double value,
         String type,
         String status,
         Double lattitude,
         Double longitude,
         String HOAname,
         Integer enclosedby) {
      assets a = new assets();

      a.asset_id = id;
      a.asset_name = name;
      a.asset_description = desc;
      a.acquisition_date = date;
      a.forrent = true;
      a.asset_value = value;
      a.type_asset = type;
      a.status = status;
      a.loc_lattitude = lattitude;
      a.loc_longitude = longitude;
      a.hoa_name = HOAname;
      a.enclosing_asset = enclosedby;

      // A record will fail to be updated if there is a single incorrect parameter
      // input
      // Ex. duplicated id, non-existent enclosing asset, non-existent hoa name

      a.updateRecord();

      return 0;
   }

   public int updateOrder_r(int asset_id,
         String rental_date,
         String reservation_date,
         int resident_id,
         Double rental_amount,
         Double discount,
         String status,
         String inspection_details,
         Double assessed_value,
         int accept_hoid,
         String accept_position,
         String accept_electiondate,
         String return_date) {

      asset_rentals r = new asset_rentals();

      r.asset_id = asset_id;
      r.rental_date = rental_date;
      r.reservation_date = reservation_date;
      r.resident_id = resident_id;
      r.rental_amount = rental_amount;
      r.discount = discount;
      r.status = status;
      r.inspection_details = inspection_details;
      r.assessed_value = assessed_value;
      r.accept_hoid = accept_hoid;
      r.accept_position = accept_position;
      r.accept_electiondate = accept_electiondate;
      r.return_date = return_date;

      r.updateRecord();

      return 0;
   }

   public int deleteOrder(int id) {
      assets a = new assets();

      a.asset_id = id;

      a.delRecord();

      return 0;
   }

   public int disposeOrder(int id) {
      assets a = new assets();

      a.asset_id = id;

      a.dispRecord();

      return 0;
   }

   public int retOrder(int id,
         String rentdate,
         String returndate) {
      asset_rentals r = new asset_rentals();

      r.asset_id = id;
      r.rental_date = rentdate;
      r.return_date = returndate;

      r.retRecord();

      return 0;
   }

   public int deleteOrder_r(int id,
         String rentdate) {
      asset_rentals r = new asset_rentals();

      r.asset_id = id;
      r.rental_date = rentdate;

      r.delRecord();

      return 0;
   }

   public int getAvailableID() {
      try {
         assets a = new assets();

         Connection conn;
         conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
         System.out.println("Connection Successful");
         PreparedStatement pstmt = conn.prepareStatement("SELECT asset_id FROM assets ORDER BY asset_id ASC");
         ResultSet rs = pstmt.executeQuery();

         ArrayList<Integer> idList = new ArrayList<Integer>();

         while (rs.next()) {
            idList.add(rs.getInt("asset_id"));
         }

         rs.close();
         pstmt.close();
         conn.close();

         int i = idList.get(idList.size() - 1) + 1;

         return i;
      } catch (SQLException ex) {
         Logger.getLogger(handler.class.getName()).log(Level.SEVERE, null, ex);
      }

      return 0;
   }

   public static void main(String[] args) {

   }
}
