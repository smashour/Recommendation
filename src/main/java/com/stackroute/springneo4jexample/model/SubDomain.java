package com.stackroute.springneo4jexample.model;

import org.neo4j.ogm.annotation.*;

import java.util.List;

@NodeEntity

public class SubDomain {
   @Id
   private Long id;
    private String subDomainName;
    private List<String> idea;

//    public Collection<User> getUser() {
//        return user;
//    }
//
//
//    public Collection<User> user = new ArrayList<>();
    public SubDomain() {
    }

    public List<String> getIdea() {
        return idea;
    }

    public SubDomain(Long id, String subDomainName, List<String> idea) {
        this.subDomainName = subDomainName;
        this.id=id;
        this.idea = idea;

    }



    public String getSubDomainName() {
        return subDomainName;
    }

    public Long getId() {
        return id;
    }
}
