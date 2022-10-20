package com.example.apielgranpollon.service;


import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apielgranpollon.entity.PlatesDetails;
import com.example.apielgranpollon.repository.PlatesDetailsRepository;

@Service
public class PlatesDetailsServiceImpl implements PlatesDetailsService{

    @Autowired
    private PlatesDetailsRepository repository;

    @Override
    @Transactional
    public void insert(PlatesDetails platesDetails) {
        repository.save(platesDetails);
    }

    @Override
    @Transactional
    public void update(PlatesDetails platesDetails) {
        repository.save(platesDetails);
    }

    @Override
    @Transactional
    public void delete(Integer platesDetailsId) {
        repository.deleteById(platesDetailsId);

    }

    @Override
    @Transactional(readOnly=true)
    public PlatesDetails findById(Integer platesDetailsId) {
        return repository.findById(platesDetailsId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<PlatesDetails> findAll() {
        return repository.findAll();
    }

}
