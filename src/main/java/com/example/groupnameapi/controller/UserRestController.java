package com.example.groupnameapi.controller;

import com.example.groupnameapi.classes.UserF;
import com.example.groupnameapi.handlers.UserHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    public InMemoryUserDetailsManager inMemoryUserDetailsManager;

    @Autowired
    public PasswordEncoder passwordEncoder;

    UserHandler userHandler = new UserHandler();

    @RequestMapping(path="", method = RequestMethod.POST)
    public String createUser(@RequestBody UserF user) {
        user.setRole("USER");
        inMemoryUserDetailsManager.createUser(User.withUsername(user.getUsername()).password(passwordEncoder.encode(user.getPassword()))
                .roles(user.getRole()).build());
        userHandler.addUser(user);
        return "User " + user.getId() + " added.";
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public UserF findOneUser(@PathVariable int id) {
        return userHandler.findUserById(id);
        // UI will take in object as JSON object, parse into object and print out values
    }

    @RequestMapping(path="/{username}/{password}", method = RequestMethod.GET)
    public UserF findOneUser(@PathVariable String username, @PathVariable String password) {
        return userHandler.findByUsernamePassword(username,password);
        // UI will take in object as JSON object, parse into object and print out values
    }

    @RequestMapping(path="", method = RequestMethod.GET)
    public ArrayList<UserF> findAllUsers() {
        return userHandler.findAllUsers();
    }

    @RequestMapping(path="/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable int id, @RequestBody UserF user) {
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
