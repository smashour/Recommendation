package com.stackroute.springneo4jexample.controller;

import com.stackroute.springneo4jexample.model.SubDomain;
import com.stackroute.springneo4jexample.service.SubDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rest/neo4j/sub")
public class SubDomainController {

    @Autowired
    public SubDomainService subDomainService;

    @GetMapping("/getall")
    public Collection<SubDomain> getAll() {

        return subDomainService.getAll();
    }

    @PostMapping("/save")
    public SubDomain saveSubDomain(@RequestBody SubDomain subDomain) {

        return subDomainService.saveSubDomain(subDomain.getId(),subDomain.getSubDomainName());
    }

}
