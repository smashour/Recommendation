package com.stackroute.springneo4jexample.service;

import com.stackroute.springneo4jexample.model.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    Role findByName(String spaceName);
}
