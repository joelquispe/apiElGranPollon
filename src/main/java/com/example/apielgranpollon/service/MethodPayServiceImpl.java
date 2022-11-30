package com.example.apielgranpollon.service;

import java.util.Collection;

import com.example.apielgranpollon.entity.MethodPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apielgranpollon.repository.MethodPayRepository;

@Service
public class MethodPayServiceImpl implements MethodPayService {

    @Autowired
    private MethodPayRepository repository;

    @Override
    @Transactional
    public void insert(MethodPay methodPay) {
        repository.save(methodPay);
    }

    @Override
    @Transactional
    public void update(MethodPay methodPay) {
        repository.save(methodPay);
    }

    @Override
    @Transactional
    public void delete(Integer methodPayId) {
        repository.deleteById(methodPayId);

    }

    @Override
    @Transactional(readOnly=true)
    public MethodPay findById(Integer methodPayId) {
        return repository.findById(methodPayId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<MethodPay> findAll() {
        return repository.findAll();
    }

}
