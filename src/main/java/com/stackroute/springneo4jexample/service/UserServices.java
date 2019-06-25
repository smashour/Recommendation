package com.stackroute.springneo4jexample.service;

import com.stackroute.springneo4jexample.model.User;
import com.stackroute.springneo4jexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface UserServices {



    public User saveUser(Long userId,String userName,String userDomain,String userSubDomain);

    public Collection<User> getAll();

//    public void deleteUser(Long id);
//
//    public User updateUser(User user);
//
//    public User getByName(String name);
//
//
//     public User saveRelation();
}
