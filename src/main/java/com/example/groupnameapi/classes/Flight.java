package com.example.groupnameapi.classes;

import java.sql.Date;
import java.sql.Time;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Flight {
    private int id;
    private String origin;
    private String destination;
    private String departureTime;
    private String arrivalTime;
    private String aircraftType;
    private int seatsTaken;
    private int seatsLeft;
    private int fare;

    private static final DateFormat TIME_FORMAT = new SimpleDateFormat("hh:mm");
    private static final DateFormat Time_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public Flight(int id, String origin, String destination, String departureTime, String arrivalTime, String aircraftType, int seatsLeft, int seatsTaken, int fare) throws ParseException {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.aircraftType = aircraftType;
        this.seatsTaken = seatsTaken;
        this.seatsLeft = seatsLeft;
        this.fare = fare;
    }

    public Flight() {
    }

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

    public String getDepartureTime() {
        return departureTime.toString();
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime.toString();
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
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

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }
}
