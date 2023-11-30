package com.example.groupnameapi.handlers;

import com.example.groupnameapi.classes.Flight;
import com.example.groupnameapi.controller.DbInteraction.DBFlight;

import java.util.ArrayList;

public class FlightHandler {
    // TEMPORARY ARRAYLIST UNTIL DATABASE CONNECTION IS MADE
    ArrayList<Flight> flights = new ArrayList<>();

    public void addFlight(Flight flight) {
        DBFlight.createFlight(flight.getId(), flight.getOrigin(), flight.getDestination(), flight.getDepartureTime(), flight.getArrivalTime(), flight.getAircraftType(), flight.getSeatsTaken(), flight.getSeatsLeft(), flight.getFare());
    }

    public Flight findFlightById(int id) {
        return DBFlight.selectOneFlight(id);
//        return flights.stream().filter(flight -> flight.getId() == id)
//                .findFirst()
//                .orElse(null);
    }

    public ArrayList<Flight> findAllFlights() {
        return DBFlight.selectFlights();
    }

    public void updateFlight(Flight flight) {
        DBFlight.updateFlight(flight.getOrigin(), flight.getDestination(), flight.getDepartureTime(), flight.getArrivalTime(), flight.getAircraftType(), flight.getSeatsTaken(), flight.getSeatsLeft(), flight.getFare(), flight.getId());
//        for (Flight currFlight : flights) {
//            if (currFlight.getId() == flight.getId()) {
//                flights.set(getIndex(currFlight), flight);
//                break;
//            }
//        }
    }

    public int getIndex(Object obj) {
        if (obj instanceof Flight) {
            return flights.indexOf(obj);
        }
        return -1;
    }

    public void removeFlight(int id) {
        DBFlight.deleteFlight(id);
//        flights.removeIf(flight -> flight.getId() == id);
    }

}
