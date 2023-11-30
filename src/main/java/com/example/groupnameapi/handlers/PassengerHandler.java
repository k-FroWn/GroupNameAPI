package com.example.groupnameapi.handlers;

import com.example.groupnameapi.classes.Passenger;
import com.example.groupnameapi.controller.DbInteraction.DBPassengerDetails;

import java.util.ArrayList;

public class PassengerHandler {
    // TEMPORARY ARRAYLIST UNTIL DATABASE CONNECTION IS MADE
    ArrayList<Passenger> passengers = new ArrayList<>();

    public void addPassenger(Passenger passenger) {
        DBPassengerDetails.createPassengerDetails(passenger.getId(), passenger.getEmail(), passenger.getFareCollected(), passenger.getTotalTimesFlown(), passenger.getCustomerID());
//        passengers.add(passenger);
//        PassengerDB.insertPassenger(passenger);
    }

    public Passenger findPassengerById(int id) {
        return DBPassengerDetails.selectPassengerDetails(id);
//        return passengers.stream().filter(passenger -> passenger.getId() == id)
//                .findFirst()
//                .orElse(null);
    }

    public ArrayList<Passenger> findAllPassengers() {
        return DBPassengerDetails.selectAllPassengerDetails();
//        return PassengerDB.selectAllPassengers();
//        return passengers;
    }

    public void updatePassenger(Passenger passenger) {
        DBPassengerDetails.updatePassengerDetails(passenger.getEmail(), passenger.getFareCollected(), passenger.getTotalTimesFlown(), passenger.getCustomerID(), passenger.getId());
//        for (Passenger currPassenger : passengers) {
//            if (currPassenger.getId() == passenger.getId()) {
//                passengers.set(getIndex(currPassenger), passenger);
//                break;
//            }
//        }
    }

    public void removePassenger(int id, String password) {
        DBPassengerDetails.deletePassengerDetails(id);
//        PassengerDB.deletePassenger(id, password);
        passengers.removeIf(passenger -> passenger.getId() == id);
    }

    public int getIndex(Object obj) {
        if (obj instanceof Passenger) {
            return passengers.indexOf(obj);
        }
        return -1;
    }
}
