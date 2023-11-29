package com.example.groupnameapi.controller.DbInteraction;

import java.sql.*;

public class DBFlight {

    static String url = "jdbc:mysql://127.0.0.1:3306/"
            + "groupnamedatabase?allowPublicKeyRetrieval=true&useSSL=false";

    static String user = "root";
    static String password = "80184";

    public static void createFlight(int id, int flightId, String origin, String destination, Date depTime, Date arriveTime, String type, int seatsLeft, int seatsTaken, int fare) {
        String sql = "Insert into groupnamedatabase.flights(id,flightId,origin,destination,depTime,arriveTime,type,seatsLeft,seatsTaken,fare) Values(?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setInt(2, flightId);
            pst.setString(3, origin);
            pst.setString(4, destination);
            pst.setDate(5, depTime);
            pst.setDate(6, arriveTime);
            pst.setString(7, type);
            pst.setInt(8, seatsLeft);
            pst.setInt(9, seatsTaken);
            pst.setInt(10, fare);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void selectFlight() {
        //String sql = "Select id, name, bookssold from testdb.authors where id=(?)";
        String sql = "Select id,flightId,origin,destination,depTime,arriveTime,type,seatsLeft,seatsTaken,fare from groupnamedatabase.flights";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getInt("flightId"));
                System.out.println(rs.getString("origin"));
                System.out.println(rs.getString("destination"));
                System.out.println(rs.getDate("depTime"));
                System.out.println(rs.getDate("arriveTime"));
                System.out.println(rs.getString("type"));
                System.out.println(rs.getInt("seatsLeft"));
                System.out.println(rs.getInt("seatsTaken"));
                System.out.println(rs.getInt("fare") + "\n\n\n");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public static void updateFlight(int flightId, String origin, String destination, Date depTime, Date arriveTime, String type, int seatsLeft, int seatsTaken, int fare, int id) {
        String sql = "update groupnamedatabase.flights set flightId=(?),origin=(?),destination=(?),depTime=(?),arriveTime=(?),type=(?),seatsLeft=(?),seatsTaken=(?),fare=(?) where id=(?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, flightId);
            pst.setString(2, origin);
            pst.setString(3, destination);
            pst.setDate(4, depTime);
            pst.setDate(5, arriveTime);
            pst.setString(6, type);
            pst.setInt(7, seatsLeft);
            pst.setInt(8, seatsTaken);
            pst.setInt(9, fare);
            pst.setInt(10, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
