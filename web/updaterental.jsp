<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*, assetandrental.*" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Updating Rental</title>
    </head>
    <body>
        <h1>Update Rental Information</h1>
        <h2>Please type in the details of the rental</h2>
        <jsp:useBean id="A" class="assetandrental.asset_rentals" scope="session" />
        <form name="recordrental" action="update_r.jsp" method="POST">
            Enter Asset ID - <select name="asset_id" id="asset_id">
                <%A.updateRental(); //placeholder
                for(int i = 0; i < A.asset_idlist.size(); i++) {%>
                    <option value="<%=asset_idlist.get(i)%>"<%=A.asset_namelist.get(i)%></option>
                <%}
                %>    
            </select><br>
            Enter Rental Date - <input type="date" name="rental_date" id="rental_date"><br>
            Enter Reservation Date - <input type="date" name="reservation_date" id="reservation_date"><br>
            Enter Resident ID - <select name="resident_id" id="resident_id">
                <% for(int i = 0; i < A.resident_idlist.size();i++) {%>
                    <option value="<%=A.resident_idlist.get(i)%>"<%=A.resident_idlist.size()%></option>
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
            Enter Accepting Officer's ID - <select name="accept_hoid" id="accept_hoid">
                <% for(int i = 0; i < A.accept_hoidlist.size();i++) {%>
                        <option value="<%=A.accept_hoidlist.get(i)%>"<%=A.accept_hoidlist.get(i)%></option>  
                <%}
                %>    
            </select><br>
            Enter Return Date - <input type="date" name="return_date" id="return_date"><br>
            <input type="submit" value="Update in database" name="Update in database" />
        </form>
    <form name="Back to main menu" action="index.jsp" method = "POST">
        	<input type="submit" value="Back to main menu" name="Back to main menu" />
    	</form>     
    </body>
</html>
