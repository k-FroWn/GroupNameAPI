package com.example.groupnameapi.model;

public class passengerDetailsModel {
    private int id;
    private String email;
    private String fareCollected;
    private String totalTimesFlown;
    private String customerID;

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

    public String getFareCollected() {
        return fareCollected;
    }

    public void setFareCollected(String fareCollected) {
        this.fareCollected = fareCollected;
    }

    public String getTotalTimesFlown() {
        return totalTimesFlown;
    }

    public void setTotalTimesFlown(String totalTimesFlown) {
        this.totalTimesFlown = totalTimesFlown;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
}
