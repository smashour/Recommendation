package com.stackroute.springneo4jexample.service;

import com.stackroute.springneo4jexample.model.SubDomain;
import com.stackroute.springneo4jexample.repository.SubDomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public class SubDomainServiceImpl implements SubDomainService {
    @Autowired
    SubDomainRepository subDomainRepository;

    @Override
    public Collection<SubDomain> getAll() {
        return subDomainRepository.getAllNode();
    }

    @Override
    public SubDomain saveSubDomain(Long id, String subDomainName) {
        SubDomain savedSubDomain=null;

        savedSubDomain=subDomainRepository.createNode(id,subDomainName);
        return savedSubDomain;
    }
}
