package com.example.groupnameapi.controller.DbInteraction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUser {

    static String url = "jdbc:mysql://127.0.0.1:3306/"
            + "groupnamedatabase?allowPublicKeyRetrieval=true&useSSL=false";

    static String user = "root";
    static String password = "80184";

    public static void createUser(int id, String username, String Password, String role, String email) {
        String sql = "Insert into groupnamedatabase.users(id,userName,password,role,email) Values(?,?,?,?,?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, username);
            pst.setString(3, Password);
            pst.setString(4, role);
            pst.setString(5, email);
            pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void selectUser() {
        //String sql = "Select id, name, bookssold from testdb.authors where id=(?)";
        String sql = "Select id,userName,password,role,email from groupnamedatabase.users";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id"));
                System.out.println(rs.getString("userName"));
                System.out.println(rs.getString("password"));
                System.out.println(rs.getString("role"));
                System.out.println(rs.getString("email")+"\n\n\n");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteUser(int id, String Password) {
        String sql = "Delete from groupnamedatabase.users where id=(?) and password=(?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, Password);
            int i = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateUser( String username, String Password, String role, String email,int id) {
        String sql = "update groupnamedatabase.users set userName=(?), password=(?),role=(?), email=(?) where id=(?)";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, Password);
            pst.setString(3, role);
            pst.setString(4, email);
            pst.setInt(5, id);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
