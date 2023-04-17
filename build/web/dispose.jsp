<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, java.util.*, assetandrental.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Disposing Asset</title>
    </head>
    <body>
        <h1>Disposing Asset</h1>
        <jsp:useBean id="arBean" class="assetandrental.handler" scope="session" />
        <%
            int asset_id = Integer.parseInt(request.getParameter("asset_id"));

            arBean.disposeOrder(asset_id);
        %>
        <br>Your asset disposed<br>
                <br>Asset Id: <%=asset_id%><br>
        <br>click <a href="deleteasset.jsp">here to go back to disposing assets</a><br>
    </body>
</html>
