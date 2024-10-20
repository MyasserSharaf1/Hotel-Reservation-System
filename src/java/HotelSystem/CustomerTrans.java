/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author xps
 */
public class CustomerTrans {
     private Connection connection;
    private Statement stmt;

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
    public List getAllRooms() throws SQLException {
        List<Rooms> roomList = new ArrayList<Rooms>();
        String sql = "SELECT typp,roomnum,roomprice FROM Rooms where status = 'available'";
        stmt=connection.createStatement();
         System.out.println(connection.getAutoCommit());
         ResultSet rs = stmt.executeQuery(sql);
        PreparedStatement statement = connection.prepareStatement(sql);
       connection.setAutoCommit(false);
        while (rs.next()) {
            Rooms room = new Rooms();
            room.setRoomnum(rs.getInt("roomnum"));
            room.setType(rs.getString("typp"));
             room.setPrice(rs.getDouble("roomprice"));
            
            roomList.add(room);
            
        }
        return roomList;
    }
    public int updateRoom( String roomtypp,int roomnum, int noofrooms) throws SQLException {
    Rooms room = null;
    int result = 0 ;
    
        String sql = "update Rooms set status = 'unavailable' where roomnum = ? and typp = ?";
        PreparedStatement prepStat = connection.prepareStatement(sql);
         prepStat.setInt(1, room.getRoomnum());
         prepStat.setString(2, room.getType());
        result = prepStat.executeUpdate();
        connection.close();
        
    
    return result;
}
    public int addCustomer(Customer cust) throws SQLException {
        String sql = "insert into customer values(?,?,?,?,?)";
        PreparedStatement prepStat = connection.prepareStatement(sql);
        prepStat.setInt(1, cust.getId());
        prepStat.setString(2, cust.getEmail());
        prepStat.setString(3, cust.getAddress());
        prepStat.setInt(4, cust.getCreditcard());
        prepStat.setString(5, cust.getFullname());

        int result = prepStat.executeUpdate();
        return result;
    }
}
