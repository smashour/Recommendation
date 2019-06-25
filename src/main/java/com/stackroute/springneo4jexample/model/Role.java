package com.stackroute.springneo4jexample.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Role {
    @GraphId
    private Long roleId;
    private String roleName;
}
