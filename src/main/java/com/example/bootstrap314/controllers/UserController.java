package com.example.bootstrap314.controllers;

import com.example.bootstrap314.entities.User;
import com.example.bootstrap314.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService usersService;

    @Autowired
    public UserController(UserService usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public ResponseEntity<User> getUserByUsername(Principal principal) {
        System.out.println(principal.getName());
        return new ResponseEntity<>(usersService.findByUsername(principal.getName()), HttpStatus.OK);
    }
}
