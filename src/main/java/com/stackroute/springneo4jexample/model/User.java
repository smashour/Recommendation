package com.stackroute.springneo4jexample.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class User {

    @GraphId
    private  Long id;
    private String name;
    private String domain;
    private String subDomain;



    public String getDomain() {
        return domain;
    }

    public String getSubDomain() {
        return subDomain;
    }
//    @Relationship(type= "LIKES")
//    private List<Movie> movies;
//
//    public List<Movie> getMovies() {
//        return movies;
//    }

    public User(Long id, String name,String domain, String subDomain) {
        this.id = id;
        this.name = name;
        this.domain = domain;
        this.subDomain = subDomain;


    }

    public User(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
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
