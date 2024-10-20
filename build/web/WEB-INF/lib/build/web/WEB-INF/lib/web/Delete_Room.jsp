<%-- 
    Document   : Delete_Room
    Created on : May 6, 2022, 5:06:37 PM
    Author     : xps
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form action="Delete_Controller.jsp">
            <h2> Enter Room Number to Delete </h2>
            <input type="number" name="roomnum">
            <input type="submit" value="Delete">
        </form>
    </body>
</html>
