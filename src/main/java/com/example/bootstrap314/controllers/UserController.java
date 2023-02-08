package com.example.bootstrap314.controllers;

import com.example.bootstrap314.entities.User;
import com.example.bootstrap314.services.RoleService;
import com.example.bootstrap314.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {
    private final UserService service;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService service, RoleService roleService) {
        this.service = service;
        this.roleService = roleService;
    }

//    @GetMapping("/registration")
//    public String registrationPage(@ModelAttribute("user") User user) {
//        return "registration";
//    }
//
//    @PostMapping("/registration")
//    public String performRegistration(@ModelAttribute("user") User user) {
//        service.registration(user);
//        return "redirect:/login";
//    }

    @GetMapping("/user")
    public String userPage(Model model, Principal principal){
        User userByName = service.findByUsername(principal.getName());
        model.addAttribute("user", userByName);
//        model.addAttribute("pageTitle", userByName.getUsername());
        return "show_user";
    }
}
