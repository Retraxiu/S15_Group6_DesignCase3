<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*, assetandrental.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recording Asset</title>
    </head>
    <body>
        <h1>Recording Asset</h1>
        <jsp:useBean id="arBean" class="assetandrental.handler" scope="session" />
        <%
            int asset_id               = arBean.getAvailableID();
            String asset_name          = request.getParameter("asset_name");
            String asset_description   = request.getParameter("asset_description");
            String acquisition_date    = request.getParameter("acquisition_date");
            String temp                = request.getParameter("forrent");
            double asset_value         = Double.parseDouble(request.getParameter("asset_value"));
            String type_asset          = request.getParameter("type_asset");
            String status              = request.getParameter("status");
            double loc_lattitude       = Double.parseDouble(request.getParameter("loc_lattitude"));
            double loc_longitude       = Double.parseDouble(request.getParameter("loc_longitude"));
            String hoa_name            = request.getParameter("hoa_name");
            Integer enclosing_asset = 0;
            if (request.getParameter("enclosing_asset") != "") {
                enclosing_asset        = Integer.parseInt(request.getParameter("enclosing_asset"));
            }

            Boolean forrent;
            if (temp == "true") {
                forrent = true;
            }
            else {
                forrent = false;
            }
            
            arBean.newOrder(asset_id,
                               asset_name,
                               asset_description,
                               acquisition_date,
                               forrent,
                               asset_value,
                               type_asset,
                               status,
                               loc_lattitude,
                               loc_longitude,
                               hoa_name,
                               enclosing_asset);
        %>
        Your asset record<br>
                Asset Id: <%=asset_id%><br>
                Asset Name: <%=asset_name%><br>
                Asset Description: <%=asset_description%><br>
                Date Acquired: <%=acquisition_date%><br>
                For Rent: <%=forrent%><br>
                Asset Value: <%=asset_value%><br>
                Asset Type: <%=type_asset%><br>
                Status: <%=status%><br>
                Latitude: <%=loc_lattitude%><br>
                Longitude: <%=loc_longitude %><br>
                HOA Name: <%=hoa_name%><br>
                Enclosing Asset: <%=enclosing_asset%><br>
        click <a href="register.jsp">here to go back to registering assets</a><br>
    </body>
</html>
