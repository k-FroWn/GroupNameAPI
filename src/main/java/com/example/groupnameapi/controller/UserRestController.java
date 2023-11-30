package com.example.groupnameapi.controller;

import com.example.groupnameapi.classes.User;
import com.example.groupnameapi.handlers.UserHandler;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserRestController {
    UserHandler userHandler = new UserHandler();

    @RequestMapping(path="", method = RequestMethod.POST)
    public String createUser(@RequestBody User user) {
        // TODO: grab user ID from database and assign a consecutive value
        // user.setID(value)
        user.setRole(false);
        userHandler.addUser(user);
        return "User " + user.getId() + " added.";
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public User findOneUser(@PathVariable int id) {
        return userHandler.findUserById(id);
        // UI will take in object as JSON object, parse into object and print out values
    }

    @RequestMapping(path="", method = RequestMethod.GET)
    public ArrayList<User> findAllUsers() {
        return userHandler.findAllUsers();
    }

    @RequestMapping(path="/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        user.setId(id);
        userHandler.updateUser(user);
        return "User " + id + " updated.";
    }

    @RequestMapping(path="/{id}/{password}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable int id, @PathVariable String password) {
        userHandler.removeUser(id, password);
        return "User " + id + "removed.";
    }

    @GetMapping("/login")
    public void login() {

    }

}
