<%-- 
    Document   : Add_Controller
    Created on : May 6, 2022, 4:56:15 PM
    Author     : xps
--%>

<%@page import="HotelSystem.RoomsConection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:useBean id="room" scope="page" class="HotelSystem.Rooms">
            <jsp:setProperty property="*" name="room"/>
        </jsp:useBean>
        <%
            RoomsConection rc = new RoomsConection();
            
            rc.establishConnection();
            
            int result = rc.addRoom(room);
            if (result == 1) {
                out.print("<b>New Room  added </b><br>");
            } else {
                out.print("<b>Failed to add the new room</b><br>");
            }
        %>
         
        <a href="index.html">Back To Home Page</a> <br>
    </body>
</html>
