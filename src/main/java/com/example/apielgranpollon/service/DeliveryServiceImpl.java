package com.example.apielgranpollon.service;


import java.util.Collection;

import com.example.apielgranpollon.entity.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apielgranpollon.repository.DeliveryRepository;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    @Autowired
    private DeliveryRepository repository;

    @Override
    @Transactional
    public void insert(Delivery delivery) {
        repository.save(delivery);
    }

    @Override
    @Transactional
    public void update(Delivery delivery) {
        repository.save(delivery);
    }

    @Override
    @Transactional
    public void delete(Integer deliveryId) {
        repository.deleteById(deliveryId);

    }

    @Override
    @Transactional(readOnly=true)
    public Delivery findById(Integer deliveryId) {
        return repository.findById(deliveryId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Delivery> findAll() {
        return repository.findAll();
    }

}