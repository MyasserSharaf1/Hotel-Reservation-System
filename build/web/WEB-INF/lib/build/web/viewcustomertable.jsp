<%-- 
    Document   : viewcustomertable
    Created on : May 15, 2022, 9:18:36 PM
    Author     : xps
--%>

<%@page import="java.util.List"%>
<%@page import="HotelSystem.Rooms"%>
<%@page import="HotelSystem.CustomerTrans"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            CustomerTrans cust = new CustomerTrans();
            
            cust.establishConnection();
            
            List<Rooms> listOfRooms = cust.getAllRooms();
            request.setAttribute("Rooms", listOfRooms);
            for(int i=0 ; i<listOfRooms.size(); i++){
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");           
            out.println("</head>");
            out.println("<body> <center><table border='1'>");
            out.println("<tr> <th>Room Number</th><th>type</th><th>Price</th></tr>");
            out.println("<tr> <td>"+listOfRooms.get(i).getRoomnum()+"</th><th>"+listOfRooms.get(i).getType()+"</th><th>"+listOfRooms.get(i).getPrice()+"</th></tr>");
            out.println(" </table></center></body>");
            out.println("</html>");
        }
            
        %>
      <!--<center>
        <table border="1">
            <tr>
                <th>Room Number</th>
                
                <th>type</th>
                <th>Price</th>
            </tr>
            <c:forEach var="room" items="${Rooms}">
                <tr>
                    <td>
                <c:out value="${room.roomnum}" />
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
       
    </center>-->
        <form action="calculate" method="post">
             Room number:<input type="text" name="roomnum"/><br><br>
             ID (2010####):<input type="text" name="id" /><br><br>
            
 <label>Choose room type:</label>
<select name="typp"><br>
  <option value="single">single</option><br>
  <option value="double">double</option><br>
</select><br><br>
           Start date <input type="date" name="datefrom" /><br><br>
           End date <input type="date" name="dateto" /><br><br>
           Credit card number: <input type="number" name="credit" /><br><br>
            <input type="submit" value="confirm"/><br><br>
             <a href="index.html">Back To Home Page</a>
        </form>
    </body>
</html>
