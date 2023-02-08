package com.example.bootstrap314.services;


import com.example.bootstrap314.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(int id);

    User getUserByUsername(String username);

    void updateUser(int id, User user);

    void removeUserById(int id);
}
