<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*, assetandrental.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recording Rental</title>
    </head>
    <body>
        <h1>Recording Rental</h1>
        <jsp:useBean id="arBean" class="assetandrental.handler" scope="session" />
        <%
            int     asset_id =           Integer.parseInt(request.getParameter("asset_id"));
            String  rental_date =        request.getParameter("rental_date");
            String  reservation_date =   request.getParameter("reservation_date");
            int     resident_id =        Integer.parseInt(request.getParameter("resident_id"));
            Double  rental_amount = 0.00;
            if (request.getParameter("rental_amount") != "") {
                rental_amount = Double.parseDouble(request.getParameter("rental_amount"));
            }
            Double  discount = 0.00;
            if (request.getParameter("discount") != "") {
                discount = Double.parseDouble(request.getParameter("discount"));
            }
            String  status =             request.getParameter("status");
            String  inspection_details = request.getParameter("inspection_details");
            Double  assessed_value = 0.00; 
            if (request.getParameter("assessed_value") != "") {
                assessed_value = Double.parseDouble(request.getParameter("assessed_value"));
            }
            int     accept_hoid = 0;
            if (request.getParameter("accept_hoid") != "") {
                accept_hoid = Integer.parseInt(request.getParameter("accept_hoid"));
            }
            String  accept_position =    request.getParameter("accept_position");
            String  accept_electiondate =    request.getParameter("accept_electiondate");
            String  return_date =        request.getParameter("return_date");
            
            arBean.newOrder_r(asset_id,
                                 rental_date,
                                 reservation_date,
                                 resident_id,
                                 rental_amount,
                                 discount,
                                 status,
                                 inspection_details,
                                 assessed_value,
                                 accept_hoid,
                                 accept_position,
                                 accept_electiondate,
                                 return_date);
        %>
        Your rental record<br>
            Asset Id: <%=asset_id%><br>
            Rental Date: <%=rental_date%><br>
            Reservation Date: <%=reservation_date%><br>
            Resident ID: <%=resident_id%><br>
            Rental Amount: <%=rental_amount%><br>
            Discount: <%=discount%><br>
            Status: <%=status%><br>
            Inspection Details : <%=inspection_details%><br>
            Assessed Value : <%=assessed_value%><br>
            Accepting Officer's ID: <%=accept_hoid%><br>
            Accepting Officer's Position: <%=accept_position%><br>
            Accepting Officer's Election Date: <%=accept_electiondate%><br>
            Return Date: <%=return_date%><br>
            
        click <a href="recordrental.jsp">here to go back to recording rentals</a><br>
    </body>
</html>
