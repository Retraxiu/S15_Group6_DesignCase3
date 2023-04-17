<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*, assetandrental.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Updating Asset</title>
    </head>
    <body>
        <h1>Update Asset Information</h1>
        <h2>Please type in the details of the asset</h2>
        <jsp:useBean id="A" class="assetandrental.assets" scope="session" />
        <form name="selectproduct" action="update.jsp" method="POST">
            Enter ID [Unique] - <select name="asset_id" id="asset_id">    
                <%
                A.updateRecord;
                for(int i = 0; i < A.asset_idlist.size();i++) { 
                %>
                    <option value="<%=A.asset_idlist.get(i)%>"><%=A.asset_namelist.get(i)%></option>
                <%}
                %>
            </select><br>
            Enter Asset Name - <input type="text" name="asset_name" id="asset_name"><br>
            Enter Asset Description - <input type="text" name="asset_description" id="asset_description"><br>
            Enter Acquisition Date [yyyy-mm-dd] - <input type="date" name="acquisition_date" id="acquisition_date"><br>
            Enter For Rent [true/false] - <select name="forrent" id="forrent">
                <option value="true">1</option>
                <option value="false">0</option>
            </select><br>
            Enter Asset Type - <select name="type_asset" id="type_asset">
                <option value = "P">Property</option>
                <option value = "E">Equipment</option>
                <option value = "F">Furniture</option>
                <option value = "O">Fixture</option>
            </select><br>
            Enter Asset Value - <input type="text" name="asset_value" id="asset_value"><br>
            Enter Status - <select name="status" id="status">
                <option value = "W">Working</option>
                <option value = "D">Deteriorated</option>
                <option value = "R">Repair</option>
                <option value = "S">For Disposal</option>
                <option value = "X">Disposed</option>
            </select><br>
            <label for="loc_lattitude:">Latitude:</label>
            <input type="number" id=""loc_lattitude name="loc_lattitude" step="0.02"><br>
            <label for="loc_longiture:">Longitude:</label>
            <input type="number" id="loc_longiture" name="loc_longiture" step="0.02"><br>
            Enter HOA Name - <select name="hoa_name" id="hoa_name">
                <%
                for(int i = 0; i < A.hoa_namelist.size();i++) { 
                %>
                    <option value="<%=A.hoa_namelist.get(i)%>"><%=A.hoa_namelist.get(i)%></option>
                <%}
                %>
            </select><br>
            Enter Enclosing Asset [Existing ID, can be empty] - <select name="enclosing_asset" id="enclosing_asset">
                <option value="">No Enclosing Asset</option>
                <%
                for(int i = 0; i < A.enclosing_assetlist.size();i++) { 
                %>
                    <option value="<%=A.enclosing_assetlist.get(i)%>"><%=A.enclosing_assetlist.get(i)%></option>
                <%}
                %> 
            </select><br>
            <input type="submit" value="Update in database" name="Update in database" />
        </form>
        <form name="Back to main menu" action="index.jsp" method = "POST">
        	<input type="submit" value="Back to main menu" name="Back to main menu" />
    	</form>     
    </body>
</html>
