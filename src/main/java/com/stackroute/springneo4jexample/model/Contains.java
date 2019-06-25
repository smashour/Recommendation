package com.stackroute.springneo4jexample.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity("contains")
public class Contains {
    @GraphId
    private Long id;

    @StartNode
    private User user;

    @EndNode
    private Role role;

}
