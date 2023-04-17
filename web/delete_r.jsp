<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*, assetandrental.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deleting Rental</title>
    </head>
    <body>
        <h1>Deleting Rental</h1>
        <jsp:useBean id="arBean" class="assetandrental.handler" scope="session" />
        <%
            int asset_id = 0;
            if (request.getParameter("asset_id") != "") {
                asset_id = Integer.parseInt(request.getParameter("asset_id"));
            }
            String rental_date = request.getParameter("rental_date");

            arBean.deleteOrder_r(asset_id,
                                 rental_date);
        %>
        <br>Your rental marked as deleted<br>
                <br>Asset Id: <%=asset_id%><br>
                <br>Rental Date: <%=rental_date%><br>
        <br>click <a href="deleterental.jsp">here to go back to deleting rentals</a><br>
    </body>
</html>
