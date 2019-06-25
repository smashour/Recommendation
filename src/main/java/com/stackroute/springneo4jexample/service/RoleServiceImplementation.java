package com.stackroute.springneo4jexample.service;

import com.stackroute.springneo4jexample.model.Role;
import com.stackroute.springneo4jexample.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImplementation implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findByName(String roleName) {
        return roleRepository.getNode(roleName);
    }
}
