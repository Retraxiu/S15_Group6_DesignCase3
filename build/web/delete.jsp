<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*, assetandrental.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deleting Asset</title>
    </head>
    <body>
        <h1>Deleting Asset</h1>
        <jsp:useBean id="arBean" class="assetandrental.handler" scope="session" />
        <%
            int asset_id = 0;
            if (request.getParameter("asset_id") != "") {
                asset_id = Integer.parseInt(request.getParameter("asset_id"));
            }
            int check_asset_id1 = 0;
            int check_asset_id2 = 0;

            Connection conn;     
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/HOADB?useTimezone=true&serverTimezone=UTC&user=root&password=12345678");
            PreparedStatement pstmt = conn.prepareStatement("SELECT asset_id, return_date FROM asset_rentals WHERE asset_id=?");
            pstmt.setInt    (1, asset_id );
            ResultSet rs = pstmt.executeQuery();   
            
            while (rs.next()) {
                check_asset_id1 = rs.getInt("asset_id");
            }
            
            pstmt = conn.prepareStatement("SELECT asset_id, act_end FROM asset_activity WHERE asset_id=?");
            pstmt.setInt    (1, asset_id );
            rs = pstmt.executeQuery();   
            
            while (rs.next()) {
                check_asset_id2 = rs.getInt("asset_id");
            }
            
            rs.close();
            pstmt.close();
            conn.close();
            
            if (check_asset_id1 == 0 && check_asset_id2 == 0) { //Check if item is already used and rented or used in activities
                arBean.deleteOrder(asset_id);
            }
        %>
        <br>Your asset deleted<br>
                <br>Asset Id: <%=asset_id%><br>
        <br>click <a href="deleteasset.jsp">here to go back to deleting assets</a><br>
    </body>
</html>
