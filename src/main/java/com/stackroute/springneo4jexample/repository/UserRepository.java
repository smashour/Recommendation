package com.stackroute.springneo4jexample.repository;

import com.stackroute.springneo4jexample.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Collection;

@Repository
public interface UserRepository extends Neo4jRepository<User,Long> {

    @Query("MATCH (u:User) RETURN u")
    Collection<User> getAllUsers();

    @Query("CREATE (u:User) SET u.id={userId},u.name={userName},u.domain={userDomain},u.subDomain={userSubDomain} RETURN u")
     public User createNode(Long userId, String userName, String userDomain, String userSubDomain);

    @Query("MATCH (u:User),(i:Idea) WHERE {u.subDomain={userSubDomain}} CREATE (u)[r:WORKOn]->(i) RETURN r")
    public User createRelatonship(String userSubDomain);


    @Query("MATCH (n:User) WHERE n.name={userName} DETACH DELETE n RETURN 'node deleted' ")
    User deleteNode(@Param("userName") String UserName);

    @Query("MATCH (u:User) WHERE u.name={userName} RETURN u")
    public User getNode(@Param("userName") String userName);

    @Query("MATCH (u:User),(i:SubDomain) WHERE u.subDomain=({subDomainName}) CREATE(i)-[:LIKE]->(u);")
    public User createRelations(@Param("subDomainName") String subDomainName);
//
//
//
//
//    @Query("MATCH (n:User) WHERE n.id={userId} SET n.userName={userName},n.age={age} RETURN n")
//    User updateNode(@Param("userId") Long userId, @Param("userName") String userName, @Param("age") int age);
//
//
//    @Query("MATCH (a:User),(b:Movie) WHERE a.id > 0 CREATE (a)-[r:LIKES]->(b) RETURN r")
//    User createRelation();
//
}
