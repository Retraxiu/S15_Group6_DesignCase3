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
    	<jsp:useBean id="A" class="assetandrental.asset" scope="session" />
    	<form name="selectproduct" action="recordasset.jsp" method="POST">
        	Asset Name:<input type="text" id="asset_name" name="asset_name"><br>
            Asset Description:<input type="text" id="asset_description" name="asset_description"><br>
            Acquisition Date:<input type="date" id="acquisition_date" name="acquisition_date"><br>
            For Renting:<select name="for_rent" id="for_rent">
                <option value="1">Yes</option>
                <option value="0">No</option>
            </select><br>
            Asset Value:<input type="text" id="asset_value" name="asset_value"><br>
	Type of Asset: <select name="asset_type" id="asset_type">
		<option value = "P">Property</option>
		<option value = "E">Equipment</option>
		<option value = "F">Furniture</option>
		<option value = "O">Fixture</option>
	</select><br>
            Status of Asset: <select name="status" id="status">
		<option value = "W">Working</option>
		<option value = "D">Deteriorated</option>
		<option value = "R">Repair</option>
		<option value = "S">For Disposal</option>
		<option value = "X">Disposed</option>
	</select><br>
	Current Location of the Asset:<br>
            <label for="loc_lattitude:">Latitude:</label>
            <input type="number" id=""loc_lattitude name="loc_lattitude" step="0.02"><br>
            <label for="loc_longiture:">Longitude:</label>
            <input type="number" id="loc_longiture" name="loc_longiture" step="0.02"><br>
            HOA Name:<select id="hoa_name" name="hoa_name">
            <%
                A.addRecord();
                for(int i = 0; i < A.hoa_namelist.size();i++) { 
            %>
            <option value="<%=A.hoa_namelist.get(i)%>"><%=A.hoa_namelist.get(i)%></option>
            <%}
            %>
            </select><br>
            Enclosing Asset:<select id="enclosing_asset" name="enclosing_asset">
                <option value="0">null</option>
            <%
                for(int i = 0; i < A.enclosing_assetlist.size();i++) { 
            %>
            <option value="<%=A.enclosing_assetlist.get(i)%>"><%=A.enclosing_assetlist.get(i)%></option>
            <%}
            %>
            </select><br>
    	<form name="Back to main menu" action="index.jsp" method = "POST">
        	<input type="submit" value="Back to main menu" name="Back to main menu" />
    	</form>
	</body>
</html>
