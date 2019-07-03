package com.stackroute.springneo4jexample.service;


import com.stackroute.springneo4jexample.model.User;
import com.stackroute.springneo4jexample.repository.UserRepository;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImplementation implements UserServices {

    @Autowired
    UserRepository userRepository;
    @Autowired
    private RabbitTemplate rabbitTemplate;


    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Collection<User> getAll() {
        return userRepository.getAllUsers();
    }

    @Override
    public User saveRelation(List<String> subDomain) {

            return userRepository.createRelatonship(subDomain);
        }
//
//    @Override
//    public User createRelation(Long id, String subDomain) {
//        return null;
//    }

    @Override
    public User saveUser(Long id, String name, String idea,List<String> subDomain,String role, List<String> skills) {
        User savedUser=null;

        savedUser=userRepository.createNode(id,name,idea,subDomain,role,skills);
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

    @Override
    public List<User> getAllUsers(String ideaName) {
        return userRepository.findByIdea(ideaName);
    }


    @RabbitListener(queues = "${serviceNeo4j.queue}")
    public void recievedMessage(User user) {
        userRepository.save(user);
        System.out.println("Recieved Message From innovator:" + user.toString());

    }


//    @Override
//    public User saveRelation() {
//        return userRepository.createRelation();
//    }





}
