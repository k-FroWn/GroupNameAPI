package com.example.groupnameapi.model;

import com.example.groupnameapi.classes.User;

import java.util.ArrayList;

public class UserHandler {
    // TEMPORARY ARRAYLIST UNTIL DATABASE CONNECTION IS MADE
    ArrayList<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }

    public User findUserById(int id) {
        return users.stream().filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public ArrayList<User> findAllUsers() {
        return users;
    }

    public void updateUser(User user) {
        for (User currUser : users) {
            if (currUser.getId() == user.getId()) {
                users.set(getIndex(currUser), user);
                break;
            }
        }
    }

    public int getIndex(Object obj) {
        if (obj instanceof User) {
            return users.indexOf(obj);
        }
        return -1;
    }

    public void removeUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }

}
