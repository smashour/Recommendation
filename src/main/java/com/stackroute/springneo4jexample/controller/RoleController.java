package com.stackroute.springneo4jexample.controller;

import com.stackroute.springneo4jexample.model.Role;
import com.stackroute.springneo4jexample.model.User;
import com.stackroute.springneo4jexample.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/neo4j/role")
public class RoleController {
    @Autowired
    public RoleService roleService;

    @GetMapping("/{roleName}")
    public Role findByName(@PathVariable String roleName) {
        return roleService.findByName(roleName);
    }

    @PostMapping("/save")
    public Role saveRole(@RequestBody Role role) {

        return roleService.saveRole(role.getRoleId(),role.getRoleName());
    }

    @PostMapping("/map")
    public User createRelation(){
        User idea1=roleService.createRelations();
        return idea1;
    }



}
