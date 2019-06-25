package com.stackroute.springneo4jexample.controller;

import com.stackroute.springneo4jexample.model.User;
import com.stackroute.springneo4jexample.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/user/")
public class UserController {

    @Autowired
    UserServices userServices;

    @GetMapping
    public Collection<User> getAll() {

        return userServices.getAll();
    }

    @PostMapping("save")
    public User saveUser(@RequestBody User user) {

        return userServices.saveUser(user.getId(), user.getName(), user.getDomain(),user.getSubDomain());
    }

//    @PutMapping("{id}")
//    public User updateUser(@RequestBody User user){
//        return userServices.updateUser(user);
//    }
//
//    @GetMapping("{name}")
//    public  User getUser(@PathVariable String name){
//       return userServices.getByName(name);
//    }
//
//    @DeleteMapping("{id}")
//    public String deleteUser(@PathVariable Long id) {
//        userServices.deleteUser(id);
//        return "Deleted User";
//    }
//
//    @PostMapping("graph")
//    public User saveRelation(){
//        return userServices.saveRelation();
//    }

}