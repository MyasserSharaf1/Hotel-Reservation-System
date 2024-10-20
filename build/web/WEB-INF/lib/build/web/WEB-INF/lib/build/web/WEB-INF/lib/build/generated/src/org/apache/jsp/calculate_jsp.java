package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.ParseException;

public final class calculate_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 private Connection connection;
    private Statement stmt;
            protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
  try {
        int cid = Integer.parseInt(request.getParameter("id"));
        int roomnum = Integer.parseInt( request.getParameter("roomnum"));
        int norooms = Integer.parseInt(request.getParameter("noofrooms"));
        String datefrom = request.getParameter("datefrom");
        Date d1=new SimpleDateFormat("dd/MM/yyyy").parse(datefrom);
        long date1InMs = d1.getTime();
        
        String dateto = request.getParameter("dateto");
        
        Date d2=new SimpleDateFormat("dd/MM/yyyy").parse(dateto);
        
        String type = request.getParameter("typp");
        
        long date2InMs = d2.getTime();
        long timeDiff = 0;
        if(date1InMs > date2InMs) {
            timeDiff = date1InMs - date2InMs;
        } else {
            timeDiff = date2InMs - date1InMs;
        }
        
        // converting diff into days
        int daysDiff = (int) (timeDiff / (1000 * 60 * 60* 24));
        if(type.equals("single")){
            int pay;
          
            pay = 500+(norooms*200)*(daysDiff) ;
            out.print("<h1>your payement is</h1> " + pay);
        }
        
        addBook( roomnum,  d1, d2, cid);
        
    } catch (ParseException ex) {
        Logger.getLogger(calculate.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(calculate.class.getName()).log(Level.SEVERE, null, ex);
    }
    } 

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
   

    public void establishConnection() throws SQLException {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/HotelSystem", "Hotel", "root"); 
            String createroom =" create table Rooms (roomnum number(10), type varchar(20), status varchar(20),price number(10)) ";
            stmt.executeUpdate (createroom);
connection.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
     
   finally {
        }
}
public int addBook(int roomnum, Date d1,Date d2,int cid) throws SQLException {
        String sql = "insert into Booking values(?,?,?,?)";
        PreparedStatement prepStat = connection.prepareStatement(sql);
        prepStat.setInt(1, roomnum);
        prepStat.setDate(2, (java.sql.Date) d1);
        prepStat.setDate(3,(java.sql.Date)d2);
        prepStat.setInt(4,cid);
        int result = prepStat.executeUpdate();
        return result;
    }
        
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
      out.write("\n");
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
