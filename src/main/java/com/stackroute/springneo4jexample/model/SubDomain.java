package com.stackroute.springneo4jexample.model;

import org.neo4j.ogm.annotation.*;

import java.util.List;

@NodeEntity
public class SubDomain {
   @Id
   private Long id;
    private String subDomainName;


    public SubDomain(Long id,String subDomainName) {
        this.subDomainName = subDomainName;
        this.id=id;
    }

    public String getSubDomainName() {
        return subDomainName;
    }

    public Long getId() {
        return id;
    }
}
