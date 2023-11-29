package com.example.groupnameapi.controller.DbInteraction;

import java.sql.*;

public class DB_C_Res {

    static String url = "jdbc:mysql://127.0.0.1:3306/"
            + "groupnamedatabase?allowPublicKeyRetrieval=true&useSSL=false";

    static String user = "root";
    static String password = "80184";

    public static void createC_Res(int id, int ticketNo, boolean refund, Date processedBy, Date cancellationDate) {
        String sql = "Insert into groupnamedatabase.cancelledres(id,ticketNo,refund,processedBy,cancellationDate) Values(?,?,?,?,?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setInt(2, ticketNo);
            pst.setBoolean(3, refund);
            pst.setDate(4, processedBy);
            pst.setDate(5, cancellationDate);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void selectC_Res() {
        //String sql = "Select id from db.example where id=(?)";
        String sql = "Select id,ticketNo,refund,processedBy,cancellationDate from groupnamedatabase.cancelledres";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getInt("ticketNo"));
                System.out.println(rs.getBoolean("refund"));
                System.out.println(rs.getDate("processedBy"));
                System.out.println(rs.getDate("cancellationDate")+"\n\n\n");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteC_Res(int id) {
        String sql = "Delete from groupnamedatabase.cancelledres where id=(?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            int i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateC_Res( int ticketNo, boolean refund, Date processedBy, Date cancellationDate, int id) {
        String sql = "update groupnamedatabase.cancelledres set ticketNo=(?), refund=(?),processedBy=(?), cancellationDate=(?) where id=(?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, ticketNo);
            pst.setBoolean(2, refund);
            pst.setDate(3, processedBy);
            pst.setDate(4, cancellationDate);
            pst.setInt(5, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
