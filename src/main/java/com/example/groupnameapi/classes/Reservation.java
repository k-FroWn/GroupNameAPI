package com.example.groupnameapi.classes;

import javax.money.MonetaryAmount;
import java.util.Date;

public class Reservation {
    private int id;
    private int flightID;
    private Date journeyDate;
    private Date reservationDate;
    private String name;
    private String email; // TEST EMAIL WITH REGEX OR OTHER VALID EMAIL TEST
    private MonetaryAmount fare;
    private String flightStatus;
    private boolean confirmed;

    public Reservation(int id, int flightID, Date journeyDate, Date reservationDate, String name, String email, MonetaryAmount fare, String flightStatus, boolean confirmed) {
        this.id = id;
        this.flightID = flightID;
        this.journeyDate = journeyDate;
        this.reservationDate = reservationDate;
        this.name = name;
        this.email = email;
        this.fare = fare;
        this.flightStatus = flightStatus;
        this.confirmed = confirmed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public Date getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(Date journeyDate) {
        this.journeyDate = journeyDate;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
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

    public MonetaryAmount getFare() {
        return fare;
    }

    public void setFare(MonetaryAmount fare) {
        this.fare = fare;
    }

    public String getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(String flightStatus) {
        this.flightStatus = flightStatus;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }
}
