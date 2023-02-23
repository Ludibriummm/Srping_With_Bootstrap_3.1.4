package com.example.bootstrap314.controllers;

import com.example.bootstrap314.entities.User;
import com.example.bootstrap314.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final UserService usersService;

    @Autowired
    public AdminController(UserService usersService) {
        this.usersService = usersService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> showAllUsers(){
        List<User> allUsers = usersService.getAllUsers();
        return (allUsers != null && !allUsers.isEmpty())
                ? new ResponseEntity<>(allUsers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        User userById = usersService.getById(id);
        return userById;
    }

    @PostMapping()
    public ResponseEntity<User> newUser(@RequestBody User user){
        usersService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        usersService.update(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<User> deleteUser(@PathVariable int id){
        if(usersService.getById(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        usersService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
