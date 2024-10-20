/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import HotelSystem.Rooms;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import static java.util.concurrent.TimeUnit.DAYS;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xps
 */
@WebServlet(urlPatterns = {"/calculate"})
public class calculate extends HttpServlet {
private Connection connection;
    private Statement stmt;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
     

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
    int pay = 0;
        int cid = Integer.parseInt(request.getParameter("id"));
        int roomnum = Integer.parseInt( request.getParameter("roomnum"));
        //int norooms = Integer.parseInt(request.getParameter("noofrooms"));
        String datefrom = request.getParameter("datefrom");
        Date d1 = null;
    try {
        d1 = new SimpleDateFormat("dd/MM/yyyy").parse(datefrom);
    } catch (ParseException ex) {
        Logger.getLogger(calculate.class.getName()).log(Level.SEVERE, null, ex);
    }
        long date1InMs = d1.getTime();
        
        String dateto = request.getParameter("dateto");
        
        Date d2 = null;
    try {
        d2 = new SimpleDateFormat("dd/MM/yyyy").parse(dateto);
    } catch (ParseException ex) {
        Logger.getLogger(calculate.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        String type = request.getParameter("typp");
        
        long date2InMs = d2.getTime();
       long timeDiff;
        if(date1InMs > date2InMs) {
            timeDiff = date1InMs - date2InMs;
        } else {
            timeDiff = date2InMs - date1InMs;
        }
       
        int daysDiff = (int) (timeDiff / (1000 * 60 * 60* 24));
        
    if(type.equals("single")){
            
            pay = 500+(200)*(daysDiff) ;
           
        }
    
    int result;
    try {
         establishConnection();
         result = addBook( roomnum,  d1, d2, cid);
         
         if(result ==1){
             request.getRequestDispatcher("Add_Customer.jsp").include(request, response);
         }
         else{
             out.print("<h2>failed to book room</h2>");
         }
    } catch (SQLException ex) {
        Logger.getLogger(calculate.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


    public void establishConnection() throws SQLException {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/HotelSystem", "Hotel", "root"); 
          
        
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
}
