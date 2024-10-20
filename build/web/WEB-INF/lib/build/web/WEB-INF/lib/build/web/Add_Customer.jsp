<%-- 
    Document   : Add_Customer
    Created on : May 17, 2022, 10:08:18 AM
    Author     : xps
--%>

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
            CustomerTrans rc = new CustomerTrans();
            
            rc.establishConnection();
            
        %>
        <form action="AddCustomer.jsp">
                <h1>Book Information</h1>
                <table>
                    <tr>
                        <td>customer id</td>
                        <td><input type="text" name="customer id"></td>
                    </tr>
                    <tr>
                        <td>email</td>
                        <td><input type="text" name="email"></td>
                    </tr>
                    <tr>
                        <td>full name</td>
                        <td><input type="text" name="full name"></td>
                    </tr>
                    <tr>
                    <tr>
                        <td>credit card</td>
                        <td><input type="number" name="credit card"></td>
                    </tr>
                    <tr>
                        <td>phone number</td>
                        <td><input type="number" name="phone number"></td>
                    </tr>
                </table>
                <input type="submit" value="Add customer" />
            </form>
    </body>
</html>
