package com.stackroute.springneo4jexample.repository;

import com.stackroute.springneo4jexample.model.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.List;

@Repository
public interface UserRepository extends Neo4jRepository<User,Long> {

    @Query("MATCH (u:User) RETURN u")
    Collection<User> getAllUsers();

    @Query("CREATE (u:User) SET u.id={id},u.name={name},u.idea={idea},u.subDomain={subDomain},u.role={role},u.skills={skills} RETURN u")
     public User createNode(Long id, String name, String idea,List<String> subDomain,String role, List<String> skills);

    @Query("MATCH (u:User),(i:Idea) WHERE {u.subDomain={subDomain}} CREATE (u)[r:WORKOn]->(i) RETURN r")
    public User createRelatonship(List<String> subDomain);


    @Query("MATCH (n:User) WHERE n.name={userName} DETACH DELETE n RETURN 'node deleted' ")
    User deleteNode(@Param("userName") String UserName);

    @Query("MATCH (u:User) WHERE u.name={userName} RETURN u")
    public User getNode(@Param("userName") String userName);

    @Query("MATCH (u:User),(i:Idea)  WHERE u.idea=({idea}) AND i.ideaName={ideaName} CREATE(u)-[:WORKED_UPON]->(i);")
    public User createRelations( String idea,String ideaName);


    @Query("MATCH (u:User) WHERE u.subDomain={subDomain} RETURN u")
    Collection<User> getAllUserDomain(@Param("subDomain")String subDomain);



    @Query("MATCH (u:User),(i:Role)  WHERE u.role=({userRole}) AND i.roleName={roleName} CREATE(u)-[:is_a]->(i);")
    User createRoles( String userRole, String roleName);

    @Query("MATCH (u:User),(i:Idea) where i.ideaName=({ideaName}) match(u)<-[:hasIdea]-(i) RETURN u LIMIT 1000")

    List<User> findByIdea(String ideaName);
//
//    @Query("MATCH(u:User)-[r:LIKES]->(s:SubDomain) RETURN r")
//    public User createRelations(@Param("subDomainName") String subDomainName);

//    @Query("MATCH (n:User) WHERE n.id={userId} SET n.userName={userName},n.age={age} RETURN n")
//    User updateNode(@Param("userId") Long userId, @Param("userName") String userName, @Param("age") int age);
//
//
//    @Query("MATCH (a:User),(b:Movie) WHERE a.id > 0 CREATE (a)-[r:LIKES]->(b) RETURN r")
//    User createRelation();
//
}
