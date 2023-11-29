package com.example.groupnameapi.model;

public class passengerDetailsModel {
    private int id;
    private String email;
    private boolean fareCollected;
    private int totalTimesFlown;
    private int customerID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getFareCollected() {
        return fareCollected;
    }

    public void setFareCollected(boolean fareCollected) {
        this.fareCollected = fareCollected;
    }

    public int getTotalTimesFlown() {
        return totalTimesFlown;
    }

    public void setTotalTimesFlown(int totalTimesFlown) {
        this.totalTimesFlown = totalTimesFlown;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
}
