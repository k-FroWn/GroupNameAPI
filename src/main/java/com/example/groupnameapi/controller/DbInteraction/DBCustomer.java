package com.example.groupnameapi.controller.DbInteraction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBCustomer {

    static String url = "jdbc:mysql://127.0.0.1:3306/"
            + "groupnamedatabase?allowPublicKeyRetrieval=true&useSSL=false";

    static String user = "root";
    static String password = "80184";

    public static void createCustomer(int id, int userID, String firstName, String lastName, String email, int flightNumber, int totalTimeFlown, boolean fareCollected) {
        String sql = "Insert into groupnamedatabase.customers(id,userID,firstName,lastName,email,flightNumber,totalTimeFlown,fareCollected) Values(?,?,?,?,?,?,?,?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setInt(2, userID);
            pst.setString(3, firstName);
            pst.setString(4, lastName);
            pst.setString(5, email);
            pst.setInt(6,flightNumber);
            pst.setInt(7,totalTimeFlown);
            pst.setBoolean(8,fareCollected);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void selectUser() {
        String sql = "Select id,userID,firstName,lastName,email,flightNumber,totalTimeFlown,fareCollected from groupnamedatabase.customers";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getInt("userID"));
                System.out.println(rs.getString("firstName"));
                System.out.println(rs.getString("lastName"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getInt("flightNumber"));
                System.out.println(rs.getInt("totalTimeFlown"));
                System.out.println(rs.getBoolean("fareCollected")+"\n\n\n");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(int id) {
        String sql = "Delete from groupnamedatabase.customers where id=(?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            int i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateUser( int userID, String firstName, String lastName, String email, int flightNumber, int totalTimeFlown, boolean fareCollected, int id) {
        String sql = "update groupnamedatabase.customers set userID=(?), firstName=(?),lastName=(?), email=(?),flightNumber=(?),totalTimeFlown=(?),fareCollected=(?) where id=(?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, userID);
            pst.setString(2, firstName);
            pst.setString(3, lastName);
            pst.setString(4, email);
            pst.setInt(5, flightNumber);
            pst.setInt(6, totalTimeFlown);
            pst.setBoolean(7, fareCollected);
            pst.setInt(8, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
