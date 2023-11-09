package com.example.groupnameapi.controller;

import com.example.groupnameapi.classes.Reservation;
import com.example.groupnameapi.model.ReservationHandler;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
public class ReservationRestController {
    ReservationHandler reservationHandler = new ReservationHandler();

    @RequestMapping(path="", method = RequestMethod.POST)
    public String createReservation(@RequestBody Reservation reservation) {
        reservationHandler.addReservation(reservation);
        return "Reservation " + reservation.getId() + " added.";
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public Reservation findOneReservation(@PathVariable int id) {
        return reservationHandler.findReservationById(id);
        // UI will take in object as JSON object, parse into object and print out values
    }

    @RequestMapping(path="/{id}", method = RequestMethod.PUT)
    public String updateReservation(@PathVariable int id, @RequestBody Reservation reservation) {
        reservation.setId(id);
        reservationHandler.updateReservation(reservation);
        return "Reservation " + id + " updated.";
    }

    @RequestMapping(path="/{id}", method = RequestMethod.DELETE)
    public String deleteReservation(@PathVariable int id) {
        reservationHandler.removeReservation(id);
        return "Reservation " + id + "removed.";
    }


}
