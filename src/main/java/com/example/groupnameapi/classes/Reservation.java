package com.example.groupnameapi.classes;

import javax.money.MonetaryAmount;
import java.util.Date;

public class Reservation {
    private int id;
    private String flightNumber;
    private String dateOfFlight;
    private String name;
    private String email;
    private String status;
    private String reservedBy;
    private String dateOfRes;
    private String confirmed;
    private String fare;
    private String ticketNo;

    public Reservation(int id, String flightNumber, String dateOfFlight, String name, String email, String status, String reservedBy, String dateOfRes, String confirmed, String fare, String ticketNo) {
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

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDateOfFlight() {
        return dateOfFlight;
    }

    public void setDateOfFlight(String dateOfFlight) {
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

    public String getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(String reservedBy) {
        this.reservedBy = reservedBy;
    }

    public String getDateOfRes() {
        return dateOfRes;
    }

    public void setDateOfRes(String dateOfRes) {
        this.dateOfRes = dateOfRes;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }
}
