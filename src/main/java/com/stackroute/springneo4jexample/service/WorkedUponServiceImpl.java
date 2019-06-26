package com.stackroute.springneo4jexample.service;

import com.stackroute.springneo4jexample.model.Idea;
import com.stackroute.springneo4jexample.repository.WorkedUponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service


    public class WorkedUponServiceImpl implements WorkedUponService {

        @Autowired
        WorkedUponRepository workedUponRepository;

        public WorkedUponServiceImpl(WorkedUponRepository workedUponRepository){
            this.workedUponRepository=workedUponRepository;
        }
        @Override
        public Collection<Idea> getRelationship() {
            return workedUponRepository.getRelationship();
        }

        @Override
        public Idea createRelations() {
            return workedUponRepository.createRelations();

        }



    }

