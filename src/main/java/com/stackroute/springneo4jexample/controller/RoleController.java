package com.stackroute.springneo4jexample.controller;

import com.stackroute.springneo4jexample.model.Role;
import com.stackroute.springneo4jexample.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/neo4j/")
public class RoleController {
    @Autowired
    public RoleService roleService;

    @GetMapping("/{roleName}")
    public Role findByName(@PathVariable String roleName) {
        return roleService.findByName(roleName);
    }

}
