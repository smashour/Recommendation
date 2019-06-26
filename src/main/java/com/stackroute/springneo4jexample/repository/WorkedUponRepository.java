package com.stackroute.springneo4jexample.repository;

import com.stackroute.springneo4jexample.model.Idea;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import java.util.Collection;

@Repository
public interface WorkedUponRepository extends Neo4jRepository<Idea,Long> {
    @Query("MATCH (u:User)<-[r:WorkedUpon]-(m:Role) RETURN r")
    public Collection<Idea> getRelationship();

    @Query("MATCH (u:User),(i:Idea) CREATE (i)-[:WORKED_UPON]->(u);")
    public Idea createRelations();
}
