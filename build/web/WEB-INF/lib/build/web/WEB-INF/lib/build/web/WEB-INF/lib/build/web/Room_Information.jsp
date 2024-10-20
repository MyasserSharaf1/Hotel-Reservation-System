<%-- 
    Document   : Room_Information
    Created on : May 13, 2022, 1:45:51 PM
    Author     : xps
--%>

<%@page import="HotelSystem.Rooms"%>
<%@page import="HotelSystem.Rooms"%>
<%@page import="HotelSystem.RoomsConection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Update_Controller.jsp">
       <jsp:useBean id="room" scope="page" class="HotelSystem.Rooms"/>
            <jsp:setProperty property="*" name="room"/>
                <table border="1">
                <%
                    
                    RoomsConection rc = new RoomsConection();
                    rc.establishConnection();
                    Rooms Room = rc.getRoom(room.getRoomnum());
                %>
               <tr>
                    <td>Price </td><td><input type="number" name="price" value='<%=Room.getPrice()%>'></td> </tr>
                
                <tr>
                    <td>room status </td><td><input type="text" name="status" value='<%=Room.getStatus()%>'></td>
                </tr>
                <tr>
                    <td>room type </td><td><input type="text" name="type" value='<%=Room.getType()%>'></td>
                </tr>
            </table>
            <input type="submit" value="Update">
        </form>
    
    </body>
</html>
