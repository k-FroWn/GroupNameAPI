package com.example.groupnameapi.handlers;

import com.example.groupnameapi.classes.UserF;
import com.example.groupnameapi.controller.DbInteraction.DBUser;

import java.util.ArrayList;

public class UserHandler {
    // TEMPORARY ARRAYLIST UNTIL DATABASE CONNECTION IS MADE
    ArrayList<UserF> users = new ArrayList<>();

    public void addUser(UserF user) {
        users.add(user);
        DBUser.createUser(user.getId(),user.getUsername(),user.getPassword(),user.getRole(),user.getEmail());
    }

    public UserF findUserById(int id) {
        return DBUser.selectUser(id);
//        return users.stream().filter(user -> user.getId() == id)
//                .findFirst()
//                .orElse(null);

    }

    public ArrayList<UserF> findAllUsers() {
        return DBUser.selectAllUsers();
//        return users;
    }

    public void updateUser(UserF user) {
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
        if (obj instanceof UserF) {
            return users.indexOf(obj);
        }
        return -1;
    }

    public UserF findByUsernamePassword(String username, String password) {
        return DBUser.selectUser(username,password);
    }
}
