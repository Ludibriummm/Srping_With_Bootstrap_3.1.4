package com.example.bootstrap314.services;

import com.example.bootstrap314.entities.Role;
import com.example.bootstrap314.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void removeRoleById(int id) {
        roleRepository.deleteById(id);
    }
    @Transactional
    public List<Role> getAllRoles() {
        return new ArrayList<>(roleRepository.findAll());
    }
}
