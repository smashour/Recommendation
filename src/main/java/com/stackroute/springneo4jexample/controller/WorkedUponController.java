package com.stackroute.springneo4jexample.controller;

import com.stackroute.springneo4jexample.model.Idea;
import com.stackroute.springneo4jexample.service.WorkedUponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/rest/neo4j")
public class WorkedUponController {

    @Autowired
    public WorkedUponService workedUponService;

    @GetMapping("/relationship")
    public Collection<Idea> getRelationship() {
        return workedUponService.getRelationship();
    }

    @PostMapping("/save")
    public Idea createRelation(){
        Idea idea1=workedUponService.createRelations();
        return idea1;
    }
}
