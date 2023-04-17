<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*, assetandrental.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Returning Rental</title>
    </head>
    <body>
        <h1>Returning Rental</h1>
        <jsp:useBean id="arBean" class="assetandrental.handler" scope="session" />
        <%
            int asset_id = 0;
            if (request.getParameter("asset_id") != "") {
                asset_id = Integer.parseInt(request.getParameter("asset_id"));
            }
            String rental_date = request.getParameter("rental_date");
            String return_date = request.getParameter("return_date");
            
            arBean.retOrder(asset_id, 
                               rental_date, 
                               return_date);
        %>
        <br>Your rental return<br>
                Asset Id: <%=asset_id%><br>
                Rental Date: <%=rental_date%><br>
                Return Date: <%=return_date%><br>
        <br>click <a href="returnrental.jsp">here to go back to returning rentals</a><br>
    </body>
</html>
