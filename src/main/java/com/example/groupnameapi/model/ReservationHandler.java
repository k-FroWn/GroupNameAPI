package com.example.groupnameapi.model;

import com.example.groupnameapi.classes.Reservation;

import java.util.ArrayList;

public class ReservationHandler {
    // TEMPORARY ARRAYLIST UNTIL DATABASE CONNECTION IS MADE
    ArrayList<Reservation> reservations = new ArrayList<>();

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public Reservation findReservationById(int id) {
        return reservations.stream().filter(reservation -> reservation.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public ArrayList<Reservation> findAllReservations() {
        return reservations;
    }

    public void updateReservation(Reservation reservation) {
        for (Reservation currReservation : reservations) {
            if (currReservation.getId() == reservation.getId()) {
                reservations.set(getIndex(currReservation), reservation);
                break;
            }
        }
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
