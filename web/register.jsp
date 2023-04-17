<%--
	Document   : register
	Created on : 04 17, 23, 6:33:36 AM
	Author 	: ccslearner
--%>

<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*, assetandrental.*" %>

<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>Recording Asset</title>
	</head>
	<body>
	<h1>Register an Asset</h1>
    	<h2>Please type in the details of the asset</h2>
    	<jsp:useBean id="arBean" class="assetandrental.handler" scope="session" />
    	<form name="selectproduct" action="recordasset.jsp" method="POST">
        	Enter Asset Name - <input type="text" name="asset_name" id="asset_name"><br>
        	Enter Asset Description - <input type="text" name="asset_description" id="asset_description"><br>
        	Enter Acquisition Date [yyyy-mm-dd] - <input type="text" name="acquisition_date" id="acquisition_date"><br>
        	Enter For Rent [true/false] - <input type="text" name="forrent" id="forrent"><br>
        	Enter Asset Type - <input type="text" name="type_asset" id="type_asset"><br>
        	Enter Asset Value - <input type="text" name="asset_value" id="asset_value"><br>
        	Enter Status - <input type="text" name="status" id="status"><br>
        	Enter Latitude - <input type="text" name="loc_lattitude" id="loc_lattitude"><br>
        	Enter Longitude - <input type="text" name="loc_longitude" id="loc_longitude"><br>
        	Enter HOA Name - <input type="text" name="hoa_name" id="hoa_name"><br>
        	Enter Enclosing Asset [Existing ID, can be empty] - <input type="text" name="enclosing_asset" id="enclosing_asset"><br>
        	<input type="submit" value="Add to database" name="Add to database" />
    	</form>
    	<form name="Back to main menu" action="index.jsp" method = "POST">
        	<input type="submit" value="Back to main menu" name="Back to main menu" />
    	</form>
	</body>
</html>
