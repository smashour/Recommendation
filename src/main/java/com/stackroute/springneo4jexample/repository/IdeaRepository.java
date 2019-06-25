package com.stackroute.springneo4jexample.repository;

import com.stackroute.springneo4jexample.model.Idea;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Collection;

public interface IdeaRepository extends Neo4jRepository<Idea,Long> {
    @Query("MATCH (u:Idea) RETURN u")
    Collection<Idea> getAllIdeas();

    @Query("CREATE (u:Idea) SET u.id={id},u.ideaName={ideaName},u.role={role},u.subDomain={subDomain} RETURN u")
    Idea createNode(Long id, String ideaName, String role,String subDomain);
}
