package com.example.groupnameapi.controller.DbInteraction;

import com.example.groupnameapi.classes.Reservation;

import java.sql.*;
import java.util.ArrayList;

public class DBRes {

    static String url = "jdbc:mysql://127.0.0.1:3306/"
            + "groupnamedatabase?allowPublicKeyRetrieval=true&useSSL=false";

    static String user = "root";
    static String password = "80184";

    public static void createReservation(int id, int flightNumber, Date dateOfFlight, String name, String email, String status,
                                         int reservedBy, Date dateOfRes, boolean confirmed, int fare, int ticketNo) {

        String sql = "Insert into groupnamedatabase.reservations(id,flightNumber, dateOfFlight,  name,  email,  status,reservedBy,  dateOfRes,  confirmed,  fare,  ticketNo) Values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setInt(2, flightNumber);
            pst.setDate(3, dateOfFlight);
            pst.setString(4, name);
            pst.setString(5, email);
            pst.setString(6, status);
            pst.setInt(7, reservedBy);
            pst.setDate(8, dateOfRes);
            pst.setBoolean(9, confirmed);
            pst.setInt(10, fare);
            pst.setInt(11, ticketNo);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Reservation selectOneReservation(int id) {
        String sql = "Select * from groupnamedatabase.reservations where id=(?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            rs.next();
            return new Reservation(
                    rs.getInt("id"),
                    rs.getInt("flightNumber"),
                    rs.getDate("dateOfFlight"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("status"),
                    rs.getInt("reservedBy"),
                    rs.getDate("dateOfRes"),
                    rs.getBoolean("confirmed"),
                    rs.getInt("fare"),
                    rs.getInt("ticketNo")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Reservation> selectReservations() {
        String sql = "Select id,flightNumber, dateOfFlight,  name,  email,  status,reservedBy,  dateOfRes,  confirmed,  fare,  ticketNo from groupnamedatabase.reservations";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            ArrayList<Reservation> reservations = new ArrayList<Reservation>();
            while (rs.next()) {
                reservations.add(new Reservation(
                        rs.getInt("id"),
                        rs.getInt("flightNumber"),
                        rs.getDate("dateOfFlight"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("status"),
                        rs.getInt("reservedBy"),
                        rs.getDate("dateOfRes"),
                        rs.getBoolean("confirmed"),
                        rs.getInt("fare"),
                        rs.getInt("ticketNo")
                ));
            }
            return reservations;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void deleteReservation(int id) {
        String sql = "Delete from groupnamedatabase.reservations where id=(?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            int i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateReservation(int flightNumber, Date dateOfFlight, String name, String email, String status,
                                         int reservedBy, Date dateOfRes, boolean confirmed, int fare, int ticketNo, int id) {

        String sql = "update groupnamedatabase.reservations set flightNumber=(?), dateOfFlight=(?),  name=(?),  email=(?),  status=(?),reservedBy=(?),  dateOfRes=(?),  confirmed=(?),  fare=(?),  ticketNo=(?) where id=(?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, flightNumber);
            pst.setDate(2, dateOfFlight);
            pst.setString(3, name);
            pst.setString(4, email);
            pst.setString(5, status);
            pst.setInt(6, reservedBy);
            pst.setDate(7, dateOfRes);
            pst.setBoolean(8, confirmed);
            pst.setInt(9, fare);
            pst.setInt(10, ticketNo);
            pst.setInt(11, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
