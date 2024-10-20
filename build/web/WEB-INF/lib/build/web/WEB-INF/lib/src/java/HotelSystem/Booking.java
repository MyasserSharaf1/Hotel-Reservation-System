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
public class Booking implements Serializable {
    int roomnum;
    Date dateto, datefrom;
    int cid;

    public Booking() {
    }

    public int getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(int roomnum) {
        this.roomnum = roomnum;
    }

    public Date getDateto() {
        return dateto;
    }

    public void setDateto(Date dateto) {
        this.dateto = dateto;
    }

    public Date getDategrom() {
        return datefrom;
    }

    public void setDategrom(Date datefrom) {
        this.datefrom = datefrom;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }
    
}
