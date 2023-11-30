package com.example.groupnameapi.model;

import java.util.Date;

public class flightModel {
    private int id;
    // note for Gavin: remove 'flightID' from database
private String origin;
private String destination;
private Date depTime;
private Date arriveTime;
private String type;
    private int seatsTaken; // note: i moved seatsTaken before seatsLeft, might have to edit database
    private int seatsLeft;
private int fair;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepTime() {
        return depTime;
    }

    public void setDepTime(Date depTime) {
        this.depTime = depTime;
    }

    public Date getArriveTime() {
        return arriveTime;
    }

    public void setArriveTime(Date arriveTime) {
        this.arriveTime = arriveTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeatsLeft() {
        return seatsLeft;
    }

    public void setSeatsLeft(int seatsLeft) {
        this.seatsLeft = seatsLeft;
    }

    public int getSeatsTaken() {
        return seatsTaken;
    }

    public void setSeatsTaken(int seatsTaken) {
        this.seatsTaken = seatsTaken;
    }

    public int getFair() {
        return fair;
    }

    public void setFair(int fair) {
        this.fair = fair;
    }
}
