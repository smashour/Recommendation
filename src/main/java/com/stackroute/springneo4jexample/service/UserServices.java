package com.stackroute.springneo4jexample.service;

import com.stackroute.springneo4jexample.model.User;
import com.stackroute.springneo4jexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface UserServices {


    User createRelation(Long id, String subDomain);

    public User saveUser(Long userId, String userName, String userDomain, String userSubDomain);

    public Collection<User> getAll();

    User saveRelation(String subDomain);

   public void deleteUser(String name);

    public User updateUser(User user);

   public User getByName(String name);

    User createRelations(String subDomainName);
//
//
//     public User saveRelation();
}
