<%-- 
    Document   : Add_Room
    Created on : May 6, 2022, 2:53:15 PM
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
        <%
            RoomsConection rc = new RoomsConection();
            
            rc.establishConnection();
            
        %>
        <form action="Add_Controller.jsp">
                <h1>Room Information</h1>
                <table>
                    <tr>
                        <td>Room Number</td>
                        <td><input type="number" name="roomnum"></td>
                    </tr>
                    <tr>
                        <td>Status</td>
                        <td><input type="text" name="status"></td>
                    </tr>
                    <tr>
                        <td>Type</td>
                        <td><input type="text" name="type"></td>
                    </tr>
                    <tr>
                    <tr>
                        <td>Price</td>
                        <td><input type="number" name="price"></td>
                    </tr>
                </table>
                <input type="submit" value="Add Room" />
            </form>
    </body>
</html>
