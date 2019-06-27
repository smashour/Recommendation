package com.stackroute.springneo4jexample.service;


import com.stackroute.springneo4jexample.model.User;
import com.stackroute.springneo4jexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;

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

    @Override
    public User saveRelation(String subDomain) {

            return userRepository.createRelatonship(subDomain);
        }

    @Override
    public User createRelation(Long id, String subDomain) {
        return null;
    }

    @Override
    public User saveUser(Long userId, String userName, String userIdea,String userSubDomain,String userRole) {
        User savedUser=null;

        savedUser=userRepository.createNode(userId,userName,userIdea,userSubDomain,userRole);
        return savedUser;

    }

    @Override
    public User getByName(String name) {
        return userRepository.getNode(name);
    }

    @Override
    public User createRelations(String idea,String ideaName) {
        return userRepository.createRelations(idea,ideaName);
    }




    @Override
    public void deleteUser(String name) {
        userRepository.deleteNode(name);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }


    @Override
    public Collection<User> getAllUsersBy(String subDomain) {
        return userRepository.getAllUserDomain(subDomain);
    }

    @Override
    public User createRoles(String role, String roleName) {
        return userRepository.createRoles(role,roleName);
    }


//    @Override
//    public User saveRelation() {
//        return userRepository.createRelation();
//    }





}
