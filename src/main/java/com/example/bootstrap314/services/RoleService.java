package com.example.bootstrap314.services;

import com.example.bootstrap314.entities.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();

    void saveRole(Role roleAdmin);

    void removeRoleById(int id);
    List<Role> getAllRoles();
}
