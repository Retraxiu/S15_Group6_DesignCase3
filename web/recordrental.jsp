<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*, assetandrental.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recording Rental</title>
    </head>
    <body>
        <h1>Record Rental</h1>
        <h2>Please type in the details of the rental</h2>
        <jsp:useBean id="arBean" class="assetandrental.handler" scope="session" />
        <form name="recordrental" action="record_r.jsp" method="POST">
            Enter Asset ID - <select name="asset_id" id="asset_id">
                <%A.addRecord(); //placeholder for rental
                for(int i = 0; i < A.asset_idlist.size(); i++) {%>
                    <option value="<%=asset_idlist.get(i)%>"<%=A.asset_namelist.get(i)%></option>
                <%}
                %>    
            </select><br>
            Enter Rental Date - <input type="date" name="rental_date" id="rental_date"><br>
            Enter Reservation Date - <input type="date" name="reservation_date" id="reservation_date"><br>
            Enter Resident ID - <select name="resident_id" id="resident_id">
                <% //placeholder for rental
                for(int i = 0; i < A.resident_idlist.size(); i++) {%>
                    <option value="<%=resident_idlist.get(i)%>"<%=A.resident_idlist.get(i)%></option>
                <%}
                %>     
            </select><br>
            Enter Rental Amount - <input type="text" name="rental_amount" id="rental_amount"><br>
            Enter Discount - <input type="text" name="discount" id="discount"><br>
            Enter Status - <select name="status" id="status">
                <option value = "R">Reserved</option>
                <option value = "C">Canceled</option>
                <option value = "O">On Rent</option>
                <option value = "N">Returned</option>
            </select><br>
            Enter Inspection Details - <input type="text" name="inspection_details" id="inspection_details"><br>
            Enter Assessed Value - <input type="text" name="assessed_value" id="assessed_value"><br>
            Enter Accepting Officer's ID - <input type="text" name="accept_hoid" id="accept_hoid"><br>
            Enter Accepting Officer's Position - <input type="text" name="accept_position" id="accept_position"><br>
            Enter Accepting Officer's Election Date - <input type="text" name="accept_electiondate" id="accept_electiondate"><br>
            Enter Return Date - <input type="text" name="return_date" id="return_date"><br>
            <input type="submit" value="Add to database" name="Add to database" />
        </form>
        <form name="Back to main menu" action="index.jsp" method = "POST">
        	<input type="submit" value="Back to main menu" name="Back to main menu" />
    	</form>     
    </body>
</html>
