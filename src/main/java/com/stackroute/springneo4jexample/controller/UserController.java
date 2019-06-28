package com.stackroute.springneo4jexample.controller;

import com.stackroute.springneo4jexample.model.User;
import com.stackroute.springneo4jexample.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

        return userServices.saveUser(user.getId(), user.getName(), user.getIdea(),user.getSubDomain(),user.getRole());
    }

    @PostMapping("graph/{subDomain}")
    public User saveRelation(@RequestBody User user,@PathVariable("subDomain") String subDomain){
        return userServices.saveRelation(user.getSubDomain());
    }

    @PutMapping("{name}")
    public User updateUser(@RequestBody User user){
        return userServices.updateUser(user);
    }


    @GetMapping("{name}")
    public  User getUser(@PathVariable String name){
        return userServices.getByName(name);
    }

    @DeleteMapping("{name}")
    public String deleteUser(@PathVariable String name) {
        userServices.deleteUser(name);
        return "Deleted User";
    }

    @PostMapping("map/{idea}/{ideaName}")
    public User createRelation(@PathVariable String idea, @PathVariable String ideaName){
        User user1=userServices.createRelations(idea,ideaName);
        return user1;
    }

    @PostMapping("graph/{role}/{roleName}")
    public User createRoles(@PathVariable String role, @PathVariable String roleName){
        User user2=userServices.createRoles(role,roleName);
        return user2;
    }


    @GetMapping("recommendations/{subDomain}")
    public Collection<User> getAllUsers(@PathVariable String subDomain) {

        return userServices.getAllUsersBy(subDomain);
    }


    @GetMapping("/recommendations/all/{ideaName}")
    public ResponseEntity<Iterable<User>> getAllUsers(@PathVariable List<String> ideaName) {
        List<User> users=new ArrayList<>();
        for (String param:ideaName) {
            users.addAll(userServices.getAllUsers(param));
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }









//

}