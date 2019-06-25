package com.stackroute.springneo4jexample.service;


import com.stackroute.springneo4jexample.model.User;
import com.stackroute.springneo4jexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImplementation implements UserServices {

    @Autowired
    UserRepository userRepository;


    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public Collection<User> getAll() {
        return userRepository.getAllUsers();
    }

//    @Override
//    public void deleteUser(Long id) {
//        userRepository.deleteNode(id);
//    }

//    @Override
//    public User updateUser(User user) {
//        return userRepository.save(user);
//    }
//
//    @Override
//    public User getByName(String name) {
//        return userRepository.getNode(name);
//    }
//
//    @Override
//    public User saveRelation() {
//        return userRepository.createRelation();
//    }

    @Override
    public User saveUser(Long userId, String userName, String userDomain,String userSubDomain) {
        User savedUser=null;

        savedUser=userRepository.createNode(userId,userName,userDomain,userSubDomain);
        return savedUser;
        
    }

}
