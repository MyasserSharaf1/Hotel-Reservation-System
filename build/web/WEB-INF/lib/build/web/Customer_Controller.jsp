<%-- 
    Document   : Customer_Controller
    Created on : May 17, 2022, 10:09:37 AM
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
        <jsp:useBean id="customer" scope="page" class="HotelSystem.Customer">
            <jsp:setProperty property="*" name="customer"/>
        </jsp:useBean>
        <%
            CustomerTrans rc = new CustomerTrans();
            
            rc.establishConnection();
            
            int result = rc.addCustomer(customer);
            if (result == 1) {
                out.print("<b>New customer  added </b><br>");
            } else {
                out.print("<b>Failed to add the new customer</b><br>");
            }
        %>
    </body>
    </body>
</html>
