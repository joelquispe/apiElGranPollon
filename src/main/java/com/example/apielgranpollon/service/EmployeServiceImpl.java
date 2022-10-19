package com.example.apielgranpollon.service;


import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apielgranpollon.entity.Employe;
import com.example.apielgranpollon.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements EmployeService{

    @Autowired
    private EmployeRepository repository;

    @Override
    @Transactional
    public void insert(Employe employe) {
        repository.save(employe);
    }

    @Override
    @Transactional
    public void update(Employe employe) {
        repository.save(employe);
    }

    @Override
    @Transactional
    public void delete(Integer employeId) {
        repository.deleteById(employeId);

    }

    @Override
    @Transactional(readOnly=true)
    public Employe findById(Integer employeId) {
        return repository.findById(employeId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Employe> findAll() {
        return repository.findAll();
    }

}