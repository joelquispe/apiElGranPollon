package com.example.apielgranpollon.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apielgranpollon.entity.Business;
import com.example.apielgranpollon.repository.BusinessRepository;

@Service
public class BusinnessServiceImpl implements BusinessService{

    @Autowired
    private BusinessRepository repository;

    @Override
    @Transactional
    public void insert(Business business) {
        repository.save(business);
    }

    @Override
    @Transactional
    public void update(Business business) {
        repository.save(business);
    }

    @Override
    @Transactional
    public void delete(Integer businessId) {
        repository.deleteById(businessId);

    }

    @Override
    @Transactional(readOnly=true)
    public Business findById(Integer businessId) {
        return repository.findById(businessId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Business> findAll() {
        return repository.findAll();
    }

}
