<%--
	Document   : index
	Created on : 04 17, 23, 6:34:31 AM
	Author 	: ccslearner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*, assetandrental.*" %>

<html>
	<head>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<title>Recording Asset</title>
	</head>
	<body>
    	<jsp:useBean id="arBean" class="assetandrental.handler" scope="session" />
    	<form name="Register Asset Information" action="register.jsp" method = "POST">
        	<input type="submit" value="Register Asset Information" name="Register Asset Information" />
    	</form>
    	<form name="Update Asset Information" action="updateasset.jsp" method = "POST">
        	<input type="submit" value="Update Asset Information" name="Update Asset Information" />
    	</form>
    	<form name="Delete Asset Information" action="deleteasset.jsp" method = "POST">
        	<input type="submit" value="Delete Asset Information" name="Delete Asset Information" />
    	</form>
    	<form name="Dispose Asset" action="disposeasset.jsp" method = "POST">
        	<input type="submit" value="Dispose Asset" name="Dispose Asset" />
    	</form>
   	 
    	<form name="Record Rental" action="recordrental.jsp" method = "POST">
        	<input type="submit" value="Record Rental" name="Record Rental" />
    	</form>
    	<form name="Return Rental" action="returnrental.jsp" method = "POST">
        	<input type="submit" value="Return Rental" name="Return Rental" />
    	</form>
    	<form name="Delete Rental Information" action="deleterental.jsp" method = "POST">
        	<input type="submit" value="Delete Rental Information" name="Delete Rental Information" />
    	</form>
    	<form name="Update Rental Information" action="updaterental.jsp" method = "POST">
        	<input type="submit" value="Update Rental Information" name="Update Rental Information" />
    	</form>
	</body>
</html>
