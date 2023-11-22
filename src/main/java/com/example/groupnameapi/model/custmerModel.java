package com.example.groupnameapi.model;

public class custmerModel {
    private int id;
    private int userId;
    private int flightNumber;
    private int totalTimeFlown;
    private String firstName;
    private String lastName;
    private String email;
    private boolean fareCollected;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getTotalTimeFlown() {
        return totalTimeFlown;
    }

    public void setTotalTimeFlown(int totalTimeFlown) {
        this.totalTimeFlown = totalTimeFlown;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isFareCollected() {
        return fareCollected;
    }

    public void setFareCollected(boolean fareCollected) {
        this.fareCollected = fareCollected;
    }
}




