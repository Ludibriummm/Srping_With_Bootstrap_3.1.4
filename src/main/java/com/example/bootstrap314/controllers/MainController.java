package com.example.bootstrap314.controllers;

import com.example.bootstrap314.entities.Role;
import com.example.bootstrap314.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String user() {
        return "userinfo";
    }

    @GetMapping("/admin")
    public String admin() {
        return "adminPage";
    }

    @GetMapping("api/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        return new ResponseEntity<>(userService.getAllRoles(), HttpStatus.OK);
    }

}
