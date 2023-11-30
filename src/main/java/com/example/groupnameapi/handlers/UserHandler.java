package com.example.groupnameapi.handlers;

import com.example.groupnameapi.classes.User;
import com.example.groupnameapi.controller.DbInteraction.DBUser;

import java.util.ArrayList;

public class UserHandler {
    // TEMPORARY ARRAYLIST UNTIL DATABASE CONNECTION IS MADE
    ArrayList<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
        DBUser.createUser(user.getId(),user.getUsername(),user.getPassword(),user.getRole(),user.getEmail());
    }

    public User findUserById(int id) {
        return DBUser.selectUser(id);
//        return users.stream().filter(user -> user.getId() == id)
//                .findFirst()
//                .orElse(null);

    }

    public ArrayList<User> findAllUsers() {
        return DBUser.selectUser();
//        return users;
    }

    public void updateUser(User user) {
        DBUser.updateUser(user.getUsername(),user.getPassword(),user.getRole(),user.getEmail(), user.getId());
//        for (User currUser : users) {
//            if (currUser.getId() == user.getId()) {
//                users.set(getIndex(currUser), user);
//                break;
//            }
//        }
    }

    public void removeUser(int id, String password) {
        DBUser.deleteUser(id, password);
//        users.removeIf(user -> user.getId() == id);
    }

    public int getIndex(Object obj) {
        if (obj instanceof User) {
            return users.indexOf(obj);
        }
        return -1;
    }

    public User findByUsernamePassword(String username, String password) {
        String Password="0";
        return DBUser.selectUser(username,Password);
    }
}
