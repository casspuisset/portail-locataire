package com.chatop.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatop.model.Users;
import com.chatop.services.UserService;

@RestController
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/:id")
    public Optional<Users> getUser(final Long id) {
        return userService.getUser(id);
    }
}
