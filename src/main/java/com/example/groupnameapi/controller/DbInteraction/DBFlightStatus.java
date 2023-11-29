package com.example.groupnameapi.controller.DbInteraction;

import java.sql.*;

public class DBFlightStatus {

    static String url = "jdbc:mysql://127.0.0.1:3306/"
            + "groupnamedatabase?allowPublicKeyRetrieval=true&useSSL=false";

    static String user = "root";
    static String password = "80184";

    public static void createFlightStatus(int id, int flightNo, Date lastUpdated, String status) {
        String sql = "Insert into groupnamedatabase.flightstatus(id,flightNo,lastUpdated,status) Values(?,?,?,?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setInt(2, flightNo);
            pst.setDate(3,lastUpdated);
            pst.setString(4, status);

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void selectFlightStatus() {
        String sql = "Select  id,flightNo,lastUpdated,status from groupnamedatabase.flightstatus";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getInt("flightNo"));
                System.out.println(rs.getDate("lastUpdated"));
                System.out.println(rs.getString("status")+"\n\n\n");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteFlightStatus(int id) {
        String sql = "Delete from groupnamedatabase.flightstatus where id=(?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            int i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateFlightStatus(int flightNo, Date lastUpdated, String status,int id ) {
        String sql = "update groupnamedatabase.flightstatus set flightNo=(?), lastUpdated=(?),status=(?) where id=(?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, flightNo);
            pst.setDate(2, lastUpdated);
            pst.setString(3, status);
            pst.setInt(4, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
