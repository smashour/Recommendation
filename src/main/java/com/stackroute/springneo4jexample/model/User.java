package com.stackroute.springneo4jexample.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.ArrayList;
import java.util.List;

@NodeEntity
public class User {

    @GraphId
    private  Long id;
    private String name;
    private String idea;
    private String subDomain;
    private String role;
    @Relationship(type = "hasIdea",direction = Relationship.OUTGOING)
    private ArrayList<String> ideaName;

    public User(){}




    public User(Long id, String name, String idea, String subDomain, String role) {
        this.id = id;
        this.name = name;
        this.idea = idea;
        this.subDomain = subDomain;
        this.role=role;

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

    public String getSubDomain() {
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
