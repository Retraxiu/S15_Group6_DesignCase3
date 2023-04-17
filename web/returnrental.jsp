<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*, assetandrental.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Returning Rental</title>
    </head>
    <body>
        <h1>Return Rental</h1>
        <h2>Please type in the details of the rental</h2>
        <jsp:useBean id="arBean" class="assetandrental.handler" scope="session" />
        <form name="selectproduct" action="return_r.jsp" method="POST">
            Enter ID [Unique] - <input type="text" name="asset_id" id="asset_id"><br>
            Enter Rental Date [Unique] - <input type="text" name="rental_date" id="rental_date"><br>
            Enter Return Date - <input type="text" name="return_date" id="return_date"><br>
            <input type="submit" value="Return in database" name="Return in database" />
        </form>
        <form name="Back to main menu" action="index.jsp" method = "POST">
        	<input type="submit" value="Back to main menu" name="Back to main menu" />
    	</form>     
    </body>
</html>
