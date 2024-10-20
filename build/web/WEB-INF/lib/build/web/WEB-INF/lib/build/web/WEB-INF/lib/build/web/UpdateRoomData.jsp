<%-- 
    Document   : UpdateRoomData
    Created on : May 7, 2022, 5:10:10 PM
    Author     : xps
--%>

<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
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
          <%
            RoomsConection rc = new RoomsConection();
            rc.establishConnection();
            List<Rooms> listOfRooms = rc.getAllRoom();
            request.setAttribute("Rooms", listOfRooms);
            for(int i=0 ; i<listOfRooms.size(); i++){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");           
            out.println("</head>");
            out.println("<body> <center><table border='1'>");
            out.println("<tr> <th>Room Number</th><th>status</th><th>type</th><th>Price</th></tr>");
            out.println("<tr> <td>"+listOfRooms.get(i).getRoomnum()+"</th><th>"+listOfRooms.get(i).getStatus()+"</th><th>"+listOfRooms.get(i).getType()+"</th><th>"+listOfRooms.get(i).getPrice()+"</th></tr>");
            out.println(" </table></center></body>");
            out.println("</html>");
        }
             
        %>
    <!--<center>
        <table border="1">
            <tr>
                <th>Room Number</th>
                <th>Status</th>
                <th>type</th>
                <th>Price</th>
            </tr>
            <c:forEach var="room" items="${Rooms}">
                <tr>
                    <td>
                <c:out value="${room.roomnum}" />
                </td>
                <td>
                <c:out value="${room.status}" />
                </td>
                <td>
                <c:out value="${room.typp}" />
                </td>
                <td>
                <c:out value="${book.price}" />
                </td>
                </tr>
            </c:forEach>
        </table>
        <a href="index.html">Back To Home Page</a>
    </center>
    </body>
</html>
PrintWriter print = response.getWriter();
             for(int i = 0; i<listOfRooms.size(); i++){
                 print.println(listOfRooms.get(i).toString());
             }
    -->
    