package com.example.groupnameapi.controller.DbInteraction;

import com.example.groupnameapi.classes.Flight;

import java.sql.*;
import java.util.ArrayList;

public class DBFlight {

    static String url = "jdbc:mysql://127.0.0.1:3306/"
            + "groupnamedatabase?allowPublicKeyRetrieval=true&useSSL=false";

    static String user = "root";
    static String password = "rootpass@2005";

    // removed FlightID, i thought we had already removed it from the database model
    public static void createFlight(int id, String origin, String destination, String depTime, String arriveTime, String type, int seatsLeft, int seatsTaken, int fare) {
        String sql = "Insert into groupnamedatabase.flights(id,origin,destination,depTime,arriveTime,type,seatsLeft,seatsTaken,fare) Values(?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, origin);
            pst.setString(3, destination);
            pst.setString(4, depTime);
            pst.setString(5, arriveTime);
            pst.setString(6, type);
            pst.setInt(7, seatsLeft);
            pst.setInt(8, seatsTaken);
            pst.setInt(9, fare);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static Flight selectOneFlight(int id) {
        String sql = "Select * from groupnamedatabase.flights where id=(?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            Flight flight = new Flight(
                    rs.getInt("id"),
                    rs.getString("origin"),
                    rs.getString("destination"),
                    rs.getString("depTime"),
                    rs.getString("arriveTime"),
                    rs.getString("type"),
                    rs.getInt("seatsLeft"),
                    rs.getInt("seatsTaken"),
                    rs.getInt("fare")
            );
            return flight;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static ArrayList<Flight> selectFlights() {
        String sql = "Select * from groupnamedatabase.flights";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ArrayList<Flight> flights = new ArrayList<>();
            while (rs.next()) {
                flights.add(new Flight(
                        rs.getInt("id"),
                        rs.getString("origin"),
                        rs.getString("destination"),
                        rs.getString("depTime"),
                        rs.getString("arriveTime"),
                        rs.getString("type"),
                        rs.getInt("seatsLeft"),
                        rs.getInt("seatsTaken"),
                        rs.getInt("fare")

                ));
            }
        return flights;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void deleteFlight(int id) {
        String sql = "Delete from groupnamedatabase.flights where id=(?) ";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            int i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateFlight(String origin, String destination, String depTime, String arriveTime, String type, int seatsLeft, int seatsTaken, int fare, int id) {
        String sql = "update groupnamedatabase.flights set flightId=(?),origin=(?),destination=(?),depTime=(?),arriveTime=(?),type=(?),seatsLeft=(?),seatsTaken=(?),fare=(?) where id=(?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, origin);
            pst.setString(2, destination);
            pst.setString(3, depTime);
            pst.setString(4, arriveTime);
            pst.setString(5, type);
            pst.setInt(6, seatsLeft);
            pst.setInt(7, seatsTaken);
            pst.setInt(8, fare);
            pst.setInt(9, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
