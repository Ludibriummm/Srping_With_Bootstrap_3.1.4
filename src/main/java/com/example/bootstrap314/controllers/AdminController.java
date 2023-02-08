package com.example.bootstrap314.controllers;

import com.example.bootstrap314.entities.User;
import com.example.bootstrap314.services.RoleService;
import com.example.bootstrap314.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping()
public class AdminController {
    private final UserService usersService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService usersService, RoleService roleService) {
        this.usersService = usersService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String getAdminPage(Model model, Principal principal) {
        model.addAttribute("users", usersService.getAllUsers());
        model.addAttribute("admin", usersService.getUserByUsername(principal.getName()));
        model.addAttribute("newUser", new User());
        model.addAttribute("rolesAdd", roleService.getRoles());
        return "admin_page";
    }

    @PostMapping("/admin")
    public String createUser(@ModelAttribute("user") User user) {
        usersService.saveUser(user);
        return "redirect:/admin";
    }

    @PatchMapping(value = "/admin/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        usersService.updateUser(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("/admin/{id}/delete")
    public String removeUserById(@PathVariable("id") int id) {
        usersService.removeUserById(id);
        return "redirect:/admin";
    }
}

