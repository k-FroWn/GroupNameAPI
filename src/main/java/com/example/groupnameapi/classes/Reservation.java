package com.example.groupnameapi.classes;

import java.sql.Date;

public class Reservation {
    private int id;
    private int flightNumber;
    private Date dateOfFlight;
    private String name;
    private String email;
    private String status;
    private int reservedBy;
    private Date dateOfRes;
    private boolean confirmed;
    private int fare;
    private int ticketNo;

    public Reservation(int id, int flightNumber, Date dateOfFlight, String name, String email, String status, int reservedBy, Date dateOfRes, boolean confirmed, int fare, int ticketNo) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.dateOfFlight = dateOfFlight;
        this.name = name;
        this.email = email;
        this.status = status;
        this.reservedBy = reservedBy;
        this.dateOfRes = dateOfRes;
        this.confirmed = confirmed;
        this.fare = fare;
        this.ticketNo = ticketNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Date getDateOfFlight() {
        return dateOfFlight;
    }

    public void setDateOfFlight(Date dateOfFlight) {
        this.dateOfFlight = dateOfFlight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(int reservedBy) {
        this.reservedBy = reservedBy;
    }

    public Date getDateOfRes() {
        return dateOfRes;
    }

    public void setDateOfRes(Date dateOfRes) {
        this.dateOfRes = dateOfRes;
    }

    public boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    public int getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(int ticketNo) {
        this.ticketNo = ticketNo;
    }
}
