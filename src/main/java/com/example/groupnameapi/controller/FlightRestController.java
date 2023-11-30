package com.example.groupnameapi.controller;

import com.example.groupnameapi.classes.Flight;
import com.example.groupnameapi.handlers.FlightHandler;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/flights")
public class FlightRestController {
    FlightHandler flightHandler = new FlightHandler();

    @RequestMapping(path="", method = RequestMethod.POST)
    public String createFlight(@RequestBody Flight flight) {
        System.out.println("Connected.");
        flightHandler.addFlight(flight);
        return "Flight " + flight.getId() + " added.";
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public Flight findOneFlight(@PathVariable int id) {
        return flightHandler.findFlightById(id);
        // UI will take in flight object as JSON object, parse into object and print out values
    }

    @RequestMapping(path="" , method = RequestMethod.GET)
    public ArrayList<Flight> findAllFlights() {
        return flightHandler.findAllFlights();
    }

    @RequestMapping(path="/{id}", method = RequestMethod.PUT)
    public String updateFlight(@PathVariable int id, @RequestBody Flight flight) {
        flight.setId(id);
        flightHandler.updateFlight(flight);
        return "Flight " + id + " updated.";
    }

    @RequestMapping(path="/{id}", method = RequestMethod.DELETE)
    public String deleteFlight(@PathVariable int id) {
        flightHandler.removeFlight(id);
        return "Flight " + id + "removed.";
    }


}
