package com.stackroute.springneo4jexample.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import java.util.List;

@NodeEntity
public class User {

    @GraphId
    private  Long id;
    private String name;
    private String idea;
    private List<String> subDomain;
    private String role;
    private  List<String> skills;


    public User(){}




    public User(Long id, String name, String idea, List<String> subDomain, String role, List<String> skills) {
        this.id = id;
        this.name = name;
        this.idea = idea;
        this.subDomain = subDomain;
        this.role=role;
        this.skills=skills;

    }

    public List<String> getSkills() {
        return skills;
    }

    public String getRole() {
        return role;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIdea() {
        return idea;
    }

    public List<String> getSubDomain() {
        return subDomain;
    }
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                '}';
//    }
}
