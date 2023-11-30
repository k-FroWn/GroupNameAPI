package com.example.groupnameapi.handlers;

import com.example.groupnameapi.classes.Reservation;
import com.example.groupnameapi.controller.DbInteraction.DBRes;

import java.util.ArrayList;

public class ReservationHandler {
    // TEMPORARY ARRAYLIST UNTIL DATABASE CONNECTION IS MADE
    ArrayList<Reservation> reservations = new ArrayList<>();

    public void addReservation(Reservation reservation) {
        DBRes.createReservation(reservation.getId(), reservation.getFlightNumber(), reservation.getDateOfFlight(), reservation.getName(), reservation.getEmail(), reservation.getStatus(), reservation.getReservedBy(), reservation.getDateOfRes(), reservation.getConfirmed(), reservation.getFare(), reservation.getTicketNo());
//        reservations.add(reservation);
    }

    public Reservation findReservationById(int id) {
        return DBRes.selectOneReservation(1);
//        return reservations.stream().filter(reservation -> reservation.getId() == id)
//                .findFirst()
//                .orElse(null);
    }

    public ArrayList<Reservation> findAllReservations() {
        return DBRes.selectReservations();
//        return reservations;
    }

    public void updateReservation(Reservation reservation) {
        DBRes.updateReservation(reservation.getFlightNumber(), reservation.getDateOfFlight(), reservation.getName(), reservation.getEmail(), reservation.getStatus(), reservation.getReservedBy(), reservation.getDateOfRes(), reservation.getConfirmed(), reservation.getFare(), reservation.getTicketNo(),reservation.getId());
//        for (Reservation currReservation : reservations) {
//            if (currReservation.getId() == reservation.getId()) {
//                reservations.set(getIndex(currReservation), reservation);
//                break;
//            }
//        }
    }

    public int getIndex(Object obj) {
        if (obj instanceof Reservation) {
            return reservations.indexOf(obj);
        }
        return -1;
    }

    public void removeReservation(int id) {
        reservations.removeIf(reservation -> reservation.getId() == id);
    }

}
