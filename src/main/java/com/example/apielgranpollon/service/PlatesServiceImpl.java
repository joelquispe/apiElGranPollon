package com.example.apielgranpollon.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apielgranpollon.entity.Plates;
import com.example.apielgranpollon.repository.PlatesRepository;

@Service
public class PlatesServiceImpl implements PlatesService{

    @Autowired
    private PlatesRepository repository;

    @Override
    @Transactional
    public void insert(Plates plates) {
        repository.save(plates);
    }

    @Override
    @Transactional
    public void update(Plates plates) {
        repository.save(plates);
    }

    @Override
    @Transactional
    public void delete(Integer platesId) {
        repository.deleteById(platesId);

    }

    @Override
    @Transactional(readOnly=true)
    public Plates findById(Integer platesId) {
        return repository.findById(platesId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Plates> findAll() {
        return repository.findAll();
    }

}
