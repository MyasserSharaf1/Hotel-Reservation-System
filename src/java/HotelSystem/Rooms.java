/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HotelSystem;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author xps
 */
public class Rooms implements Serializable {
    String typp, status ;
    int roomnum;
    Double price;

    public Rooms() {
    }

    public String getType() {
        return typp;
    }

   
    public void setType(String type) {
        this.typp = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(int roomnum) {
        this.roomnum = roomnum;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
     @Override
    public String toString() {
        return "Rooms{" + "typp=" + typp + ", status=" + status + ", roomnum=" + roomnum + ", price=" + price + '}';
    }

}
