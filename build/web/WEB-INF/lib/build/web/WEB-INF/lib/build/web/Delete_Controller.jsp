<%-- 
    Document   : Delete_Controller
    Created on : May 6, 2022, 5:08:21 PM
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
            //int id = Integer.parseInt(request.getParameter("id"));
            RoomsConection rc = new RoomsConection();
            rc.establishConnection();
            room.getRoomnum();
            int result = rc.deleteRoom(room.getRoomnum());
            if (result == 1) {
                out.print("<b>Room deleted successfully</b><br>");
            } else {
                out.print("<b>Failed to delete the Room</b><br>");
            }
        %>
     
        <a href="index.html">Back To Home Page</a> <br>
    </body>
</html>
