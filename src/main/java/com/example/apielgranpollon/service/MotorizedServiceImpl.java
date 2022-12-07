package com.example.apielgranpollon.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apielgranpollon.entity.Motorized;
import com.example.apielgranpollon.repository.MotorizedRepository;

@Service
public class MotorizedServiceImpl implements MotorizedService{

    @Autowired
    private MotorizedRepository repository;

    @Override
    @Transactional
    public void insert(Motorized motorized) {
        repository.save(motorized);
    }

    @Override
    @Transactional
    public void update(Motorized motorized) {
        repository.save(motorized);
    }

    @Override
    @Transactional
    public void delete(Integer motorizedId) {
        repository.deleteById(motorizedId);

    }

    @Override
    @Transactional(readOnly=true)
    public Motorized findById(Integer motorizedId) {
        return repository.findById(motorizedId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Motorized> findAll() {
        return repository.findAll();
    }

    @Override
    public Motorized findByEmailAndPassword(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

}
