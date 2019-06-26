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

    @PostMapping("map/{subDomainName}")
    public User createRelation(@PathVariable String subDomainName){
        User idea1=userServices.createRelations(subDomainName);
        return idea1;
    }

//    @PostMapping("graph/user/{userSubDomain}/idea/{ideaRole}")
//    public ResponseEntity hasRole(@PathVariable("userSubDomain") String userSubDomain, @PathVariable("ideaRole") String ideaRole)
//    {
//        ResponseEntity responseEntity;
//        userServices.createRelation(user.getSubDomain(),subDomain);
//        responseEntity=new ResponseEntity("Create", HttpStatus.OK);
//        return responseEntity;
//    }






//

}