package com.stackroute.springneo4jexample.repository;

import com.stackroute.springneo4jexample.model.Role;
import com.stackroute.springneo4jexample.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends Neo4jRepository<Role,Long> {

    @Query("MATCH (n:Role) WHERE n.RoleName={roleName} RETURN n")
    public Role getNode(@Param("roleName") String roleName);

    @Query("CREATE (r:Role) SET r.id={roleId},r.name={roleName} RETURN r")
    Role getRole(Long roleId, String roleName);

    @Query("MATCH (u:User),(r:Role)  CREATE (u)-[:is_a]->(r);")
    User createRelations();
}
