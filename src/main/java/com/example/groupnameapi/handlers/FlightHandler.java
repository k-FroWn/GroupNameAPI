package com.example.groupnameapi.handlers;

import com.example.groupnameapi.classes.Flight;

import java.util.ArrayList;

public class FlightHandler {
    // TEMPORARY ARRAYLIST UNTIL DATABASE CONNECTION IS MADE
    ArrayList<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public Flight findFlightById(int id) {
        return flights.stream().filter(flight -> flight.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public ArrayList<Flight> findAllFlights() {
        return flights;
    }

    public void updateFlight(Flight flight) {
        for (Flight currFlight : flights) {
            if (currFlight.getId() == flight.getId()) {
                flights.set(getIndex(currFlight), flight);
                break;
            }
        }
    }

    public int getIndex(Object obj) {
        if (obj instanceof Flight) {
            return flights.indexOf(obj);
        }
        return -1;
    }

    public void removeFlight(int id) {
        flights.removeIf(flight -> flight.getId() == id);
    }

}
