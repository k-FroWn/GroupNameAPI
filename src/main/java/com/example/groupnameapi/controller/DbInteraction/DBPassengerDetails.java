package com.example.groupnameapi.controller.DbInteraction;

import com.example.groupnameapi.classes.Passenger;
import org.springframework.security.core.parameters.P;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBPassengerDetails {

    static String url = "jdbc:mysql://127.0.0.1:3306/"
            + "groupnamedatabase?allowPublicKeyRetrieval=true&useSSL=false";

    static String user = "root";
    static String password = "80184";

    public static void createPassengerDetails(int id, String email, boolean fareCollected, int totalTimesFlown, int customerID) {
        String sql = "Insert into groupnamedatabase.passangerdetail(id,  email,  fareCollected,  totalTimesFlown, customerID) Values(?,?,?,?,?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, email);
            pst.setBoolean(3, fareCollected);
            pst.setInt(4, totalTimesFlown);
            pst.setInt(5, customerID);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static Passenger selectPassengerDetails(int id) {
        String sql = "Select id,  email,  fareCollected,  totalTimesFlown, customerID from groupnamedatabase.passangerdetail where id=(?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();
            return new Passenger(
                    rs.getInt("id"),
                    rs.getString("email"),
                    rs.getBoolean("fareCollected"),
                    rs.getInt("totalTimesFlown"),
                    rs.getInt("customerID")
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Passenger> selectAllPassengerDetails() {
        String sql = "Select id,  email,  fareCollected,  totalTimesFlown, customerID from groupnamedatabase.passangerdetail";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ArrayList<Passenger> passengers = new ArrayList<>();

            while (rs.next()) {
                passengers.add(new Passenger(
                        rs.getInt("id"),
                        rs.getString("email"),
                        rs.getBoolean("fareCollected"),
                        rs.getInt("totalTimesFlown"),
                        rs.getInt("customerID")
                ));
            }
            return passengers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void deletePassengerDetails(int id) {
        String sql = "Delete from groupnamedatabase.passangerdetail where id=(?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            int i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updatePassengerDetails(  String email, boolean fareCollected, int totalTimesFlown, int customerID,int id) {
        String sql = "update groupnamedatabase.passangerdetail set email=(?), fareCollected=(?),totalTimesFlown=(?), customerID=(?) where id=(?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, email);
            pst.setBoolean(2, fareCollected);
            pst.setInt(3, totalTimesFlown);
            pst.setInt(4, customerID);
            pst.setInt(5, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
