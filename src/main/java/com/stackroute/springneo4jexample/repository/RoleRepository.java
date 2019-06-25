package com.stackroute.springneo4jexample.repository;

import com.stackroute.springneo4jexample.model.Role;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends Neo4jRepository<Role,Long> {

    @Query("MATCH (n:Space) WHERE n.spaceName={spaceName} RETURN n")
    public Role getNode(@Param("roleName") String roleName);
}
