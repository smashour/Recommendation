package com.stackroute.springneo4jexample.service;

import com.stackroute.springneo4jexample.model.Idea;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface WorkedUponService {
    Collection<Idea> getRelationship();

    Idea createRelations();
}
