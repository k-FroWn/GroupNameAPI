package com.example.groupnameapi.model;

import com.example.groupnameapi.classes.User;
import com.example.groupnameapi.controller.DB;

import java.util.ArrayList;

public class UserHandler {
    // TEMPORARY ARRAYLIST UNTIL DATABASE CONNECTION IS MADE
    ArrayList<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
        DB.insertUser(user);
    }

    public User findUserById(int id) {
        return DB.selectUser(id);
//        return users.stream().filter(user -> user.getId() == id)
//                .findFirst()
//                .orElse(null);
    }

    public ArrayList<User> findAllUsers() {
        return DB.selectAllUsers();
//        return users;
    }

    public void updateUser(User user) {
        DB.updateUser(user);
//        for (User currUser : users) {
//            if (currUser.getId() == user.getId()) {
//                users.set(getIndex(currUser), user);
//                break;
//            }
//        }
    }

    public void removeUser(int id, String password) {
        DB.deleteUser(id, password);
//        users.removeIf(user -> user.getId() == id);
    }

    public int getIndex(Object obj) {
        if (obj instanceof User) {
            return users.indexOf(obj);
        }
        return -1;
    }
}
