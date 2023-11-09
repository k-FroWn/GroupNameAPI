package com.example.groupnameapi.classes;

import javax.money.MonetaryAmount;
import java.util.Date;

public class Flight {
    private int id;
    private String origin;
    private String destination;
    private Date departureTime;
    private Date arrivalTime;
    private String aircraftType;
    private boolean seatsAvailable;
    private MonetaryAmount fare;

    public Flight(int id, String origin, String destination, Date departureTime, Date arrivalTime, String aircraftType, boolean seatsAvailable, MonetaryAmount fare) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.aircraftType = aircraftType;
        this.seatsAvailable = seatsAvailable;
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

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public boolean isSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(boolean seatsAvailable) {
        this.seatsAvailable = seatsAvailable;
    }

    public MonetaryAmount getFare() {
        return fare;
    }

    public void setFare(MonetaryAmount fare) {
        this.fare = fare;
    }
}
