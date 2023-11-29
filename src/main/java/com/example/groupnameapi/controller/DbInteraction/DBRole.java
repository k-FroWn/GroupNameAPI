package com.example.groupnameapi.controller.DbInteraction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBRole {

    static String url = "jdbc:mysql://127.0.0.1:3306/"
            + "groupnamedatabase?allowPublicKeyRetrieval=true&useSSL=false";

    static String user = "root";
    static String password = "80184";


    public static void createRole(int id, String theRoles) {
        String sql = "Insert into groupnamedatabase.roles(id,theRoles) Values(?,?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, theRoles);

            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void selectRole() {
        String sql = "Select  id, theRoles from groupnamedatabase.roles";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("theRoles")+"\n\n\n");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteRole(int id) {
        String sql = "Delete from groupnamedatabase.roles where id=(?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            int i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateRole( String theRoles,int id) {
        String sql = "update groupnamedatabase.roles set theRoles=(?) where id=(?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, theRoles);
            pst.setInt(2, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
