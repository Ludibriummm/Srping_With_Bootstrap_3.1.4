package com.example.bootstrap314.services;


import com.example.bootstrap314.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    boolean save(User user);
    List<User> getAllUsers();
    User update(User user);
    User getById(int id);
    boolean delete(int id);
    User findByUsername(String name);
}
