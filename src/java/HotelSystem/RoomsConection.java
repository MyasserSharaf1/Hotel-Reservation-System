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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author xps
 */
public class RoomsConection {
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

    
    
    public int addRoom(Rooms room) throws SQLException {
        String sql = "insert into Rooms values(?,?,?,?)";
        PreparedStatement prepStat = connection.prepareStatement(sql);
        prepStat.setInt(1, room.getRoomnum());
        prepStat.setString(2, room.getStatus());
        prepStat.setString(3, room.getType());
        prepStat.setDouble(4, room.getPrice());
        int result = prepStat.executeUpdate();
        return result;
    }
    
public int updateRoom(int roomnum) throws SQLException {
    Rooms room = null;
        String sql = "update Rooms set typp = ?, status = ?,roomprice= ? where roomnum = ?";
        PreparedStatement prepStat = connection.prepareStatement(sql);
       prepStat.setString(1, room.getType());
        prepStat.setString(2, room.getStatus());
         prepStat.setDouble(3, room.getPrice());
         prepStat.setInt(4, room.getRoomnum());
        int result = prepStat.executeUpdate();
        connection.close();
        return result;
}

public int deleteRoom(int roomnum) throws SQLException {
        String sql = "DELETE FROM Rooms where roomnum = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,roomnum);
        int rowDeleted = statement.executeUpdate();
        connection.close();
        return rowDeleted;
    }

public List getAllRoom() throws SQLException {
        List<Booking> roomList = new ArrayList<Booking>();
        String sql = "select * from Booking where trunc(months_between(dateto,datefrom)*30)=30";
        stmt=connection.createStatement();
         System.out.println(connection.getAutoCommit());
         ResultSet rs = stmt.executeQuery(sql);
        
       connection.setAutoCommit(false);
        while (rs.next()) {
            Booking room = new Booking();
            room.setRoomnum(rs.getInt("roomnum"));
            room.setDategrom(rs.getDate("datefrom"));
           room.setDateto(rs.getDate("dateto"));
             room.setCid(rs.getInt("cid"));
            
            roomList.add(room);
            
        }
        return roomList;
    }
public Rooms getRoom(int roomnum) throws SQLException {
        Rooms roomData = new Rooms();
        String sql = "SELECT * FROM Rooms WHERE roomnum= ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,roomnum);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
        roomData.setType(rs.getString("typp"));
        roomData.setStatus(rs.getString("status"));
        roomData.setPrice(rs.getDouble("roomprice"));
        roomData.setRoomnum(rs.getInt("roomnum"));
        }
        return roomData;
    }

}