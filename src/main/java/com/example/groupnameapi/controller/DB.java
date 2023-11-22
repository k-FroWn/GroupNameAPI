package com.example.groupnameapi.controller;

import com.example.groupnameapi.classes.User;

import java.sql.*;
import java.util.ArrayList;

public class DB {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/"
            + "groupnamedatabase?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "rootpass@2005"; // this is my database password lol, idk how to change it - Kaavya

    public static void insertUser(User user) {
        createUser(user.getId(), user.getUsername(), user.getPassword(), user.getRole(), user.getEmail());
    }

    public static void createUser(int id, String username, String Password, boolean role, String email) {
        String sql = "Insert into groupnamedatabase.users(id,userName,password,role,email) Values(?,?,?,?,?)";
        try {
            Connection conn = DriverManager.getConnection(URL, DB.DB_USERNAME, DB_PASSWORD);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, username);
            pst.setString(3, Password);
            pst.setBoolean(4, role);
            pst.setString(5, email);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static User selectUser(int id) {
        //String sql = "Select id, name, bookssold from testdb.authors where id=(?)";
        String sql = "Select * from groupnamedatabase.users where id = " + id;
        try {
            Connection conn = DriverManager.getConnection(URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            rs.next();
            return compileOneUser(rs);
//            while (rs.next()) {
//                User user = compileUser(rs);
//                System.out.println(rs.getInt("id"));
//                System.out.println(rs.getString("userName"));
//                System.out.println(rs.getString("password"));
//                System.out.println(rs.getString("role"));
//                System.out.println(rs.getString("email")+"\n\n\n");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new User();
    }

    public static ArrayList<User> selectAllUsers() {
        String sql = "Select * from groupnamedatabase.users";
        try {
            Connection conn = DriverManager.getConnection(URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            return compileAllUsers(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public static User compileOneUser(ResultSet rs) {
        try {
            return new User(rs.getInt("id"), rs.getString("userName"), rs.getString("password"), rs.getBoolean("role"), rs.getString("email"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<User> compileAllUsers(ResultSet rs) {
        ArrayList<User> users = new ArrayList<>();
        try {
            while (rs.next()) {
                users.add(compileOneUser(rs));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteUser(int id, String Password) {
        String sql = "Delete from groupnamedatabase.users where id=(?) and password=(?)";
        try {
            Connection conn = DriverManager.getConnection(URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            pst.setString(2, Password);
            int rows = pst.executeUpdate();
            System.out.println(rows + " rows affected.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateUser(User user) {
        String sql = "update groupnamedatabase.users set userName=(?), password=(?),role=(?), email=(?) where id=(?)";
        try {
            Connection conn = DriverManager.getConnection(URL, DB_USERNAME, DB_PASSWORD);
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setBoolean(3, user.getRole());
            pst.setString(4, user.getEmail());
            pst.setInt(5, user.getId());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
