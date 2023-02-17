package com.example.bootstrap314.controllers;

import com.example.bootstrap314.entities.User;
import com.example.bootstrap314.services.RoleService;
import com.example.bootstrap314.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class RestAPIController {
    private final UserService usersService;

    @Autowired
    public RestAPIController(UserService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/admin")
    public ResponseEntity<Collection<User>> showAllUsers(){
        List<User> allUsers = usersService.getAllUsers();
        return (allUsers != null && !allUsers.isEmpty())
                ? new ResponseEntity<>(allUsers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/admin/{id}")
    public User getUserById(@PathVariable int id){
        User userById = usersService.getById(id);
        return userById;
    }

    @PostMapping("/admin/users")
    public ResponseEntity<User> newUser(@RequestBody User user){
        usersService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/admin")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        usersService.update(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/admin/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id){
        if(usersService.getById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        usersService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUserByUsername(Principal principal) {
        System.out.println(principal.getName());
        return new ResponseEntity<>(usersService.findByUsername(principal.getName()), HttpStatus.OK);
    }

//    @GetMapping("/admin")
//    public String getAdminPage(Model model, Principal principal) {
//        model.addAttribute("users", usersService.getAllUsers());
//        model.addAttribute("admin", usersService.findByUsername(principal.getName()));
//        model.addAttribute("newUser", new User());
//        model.addAttribute("rolesAdd", roleService.getRoles());
//        return "adminPage";
//    }
//
//    @PostMapping("/admin")
//    public String createUser(@ModelAttribute("user") User user) {
//        usersService.save(user);
//        return "redirect:/admin";
//    }
//
//    @PatchMapping(value = "/admin/{id}")
//    public String updateUser(@ModelAttribute("user") User updatedUser, @PathVariable("id") int id) {
//        User existingUser = usersService.getById(id);
//        existingUser.setUsername(updatedUser.getUsername());
//        existingUser.setEmail(updatedUser.getEmail());
//        existingUser.setLastname(updatedUser.getLastname());
//        existingUser.setAge(updatedUser.getAge());
//        existingUser.setRoles(updatedUser.getRoles());
//        usersService.update(existingUser);
//        return "redirect:/admin";
//    }
//
//    @DeleteMapping("/admin/{id}/delete")
//    public String removeUserById(@PathVariable("id") int id) {
//        usersService.delete(id);
//        return "redirect:/admin";
//    }
}

