package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.OrderDetails;
import com.example.apielgranpollon.repository.OrderDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class OrderDetailsServiceImpl implements  OrderDetailsService{
    @Autowired
    private OrderDetailsRepository repository;

    @Override
    public void insert(OrderDetails orderDetails) {
        repository.save(orderDetails);
    }

    @Override
    @Transactional
    public void update(OrderDetails orderDetails) {
        repository.save(orderDetails);
    }

    @Override
    public void delete(Integer orderDetailsId) {
        repository.deleteById(orderDetailsId);
    }

    @Override
    public OrderDetails findById(Integer orderDetailsId) {
        return repository.findById(orderDetailsId).orElse(null);
    }

    @Override
    public OrderDetails findByOrder(Integer idOrder) {
        return repository.findByOrder(idOrder);
    }

    @Override
    public Collection<OrderDetails> findAll() {
        return repository.findAll();
    }
}
