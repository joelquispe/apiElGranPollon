package com.example.apielgranpollon.service;

import java.util.Collection;

import com.example.apielgranpollon.entity.Motorized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apielgranpollon.entity.MotorizedStatus;
import com.example.apielgranpollon.repository.MotorizedStatusRepository;

@Service
public class MotorizedStatusServiceImpl implements MotorizedStatusService{

    @Autowired
    private MotorizedStatusRepository repository;

    @Override
    @Transactional
    public void insert(MotorizedStatus motorizedStatus) {
        repository.save(motorizedStatus);
    }

    @Override
    @Transactional
    public void update(MotorizedStatus motorizedStatus) {
        repository.save(motorizedStatus);
    }

    @Override
    @Transactional
    public void delete(Integer motorizedStatusId) {
        repository.deleteById(motorizedStatusId);

    }

    @Override
    @Transactional(readOnly=true)
    public MotorizedStatus findById(Integer motorizedStatusId) {
        return repository.findById(motorizedStatusId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<MotorizedStatus> findAll() {
        return repository.findAll();
    }



}
