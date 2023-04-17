<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*, assetandrental.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Disposing Asset</title>
    </head>
    <body>
        <h1>Dispose an Asset</h1>
        <h2>Please type in the details of the asset</h2>
        <jsp:useBean id="arBean" class="assetandrental.handler" scope="session" />
        <form name="selectproduct" action="dispose.jsp" method="POST">
            Enter ID [Unique] - <input type="text" name="asset_id" id="asset_id"><br>
            <input type="submit" value="Dispose from database" name="Dispose from database" />
        </form>
        <form name="Back to main menu" action="index.jsp" method = "POST">
        	<input type="submit" value="Back to main menu" name="Back to main menu" />
    	</form>     
    </body>
</html>
