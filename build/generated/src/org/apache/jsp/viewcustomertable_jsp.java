package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import HotelSystem.Rooms;
import HotelSystem.CustomerTrans;

public final class viewcustomertable_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

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
            
        
      out.write("\n");
      out.write("      <!--<center>\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Room Number</th>\n");
      out.write("                \n");
      out.write("                <th>type</th>\n");
      out.write("                <th>Price</th>\n");
      out.write("            </tr>\n");
      out.write("            <c:forEach var=\"room\" items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${Rooms}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                <tr>\n");
      out.write("                    <td>\n");
      out.write("                <c:out value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${room.roomnum}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                <c:out value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${room.typp}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\n");
      out.write("                </td>\n");
      out.write("                <td>\n");
      out.write("                <c:out value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${book.price}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\n");
      out.write("                </td>\n");
      out.write("                </tr>\n");
      out.write("            </c:forEach>\n");
      out.write("        </table>\n");
      out.write("       \n");
      out.write("    </center>-->\n");
      out.write("        <form action=\"calculate\" method=\"post\">\n");
      out.write("             Room number:<input type=\"text\" name=\"roomnum\"/><br><br>\n");
      out.write("             ID (2010####):<input type=\"text\" name=\"id\" /><br><br>\n");
      out.write("            \n");
      out.write(" <label>Choose room type:</label>\n");
      out.write("<select name=\"typp\"><br>\n");
      out.write("  <option value=\"single\">single</option><br>\n");
      out.write("  <option value=\"double\">double</option><br>\n");
      out.write("</select><br><br>\n");
      out.write("           Start date <input type=\"date\" name=\"datefrom\" /><br><br>\n");
      out.write("           End date <input type=\"date\" name=\"dateto\" /><br><br>\n");
      out.write("           Credit card number: <input type=\"number\" name=\"credit\" /><br><br>\n");
      out.write("            <input type=\"submit\" value=\"confirm\"/><br><br>\n");
      out.write("             <a href=\"index.html\">Back To Home Page</a>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
