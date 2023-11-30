package com.example.groupnameapi.classes;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight {
    private int id;
    private String origin;
    private String destination;
    private Time departureTime;
    private Time arrivalTime;
    private String aircraftType;
    private int seatsTaken;
    private int seatsLeft;
    private String fare;

    private static final DateFormat TIME_FORMAT = new SimpleDateFormat("hh:mm");
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    public Flight(int id, String origin, String destination, String departureTime, String arrivalTime, String aircraftType, int seatsLeft, int seatsTaken, String fare) throws ParseException {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = new Time(TIME_FORMAT.parse(departureTime).getTime());
        this.arrivalTime = new Time(TIME_FORMAT.parse(arrivalTime).getTime());
        this.aircraftType = aircraftType;
        this.seatsTaken = seatsTaken;
        this.seatsLeft = seatsLeft;
        this.fare = fare;
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

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
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

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }
}
