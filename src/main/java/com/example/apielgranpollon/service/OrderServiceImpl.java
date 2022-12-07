package com.example.apielgranpollon.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apielgranpollon.entity.Order;
import com.example.apielgranpollon.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository repository;

    @Override
    @Transactional
    public void insert(Order order) {
        repository.save(order);
    }

    @Override
    @Transactional
    public void update(Order order) {
        repository.save(order);
    }

    @Override
    @Transactional
    public void delete(Integer orderId) {
        repository.deleteById(orderId);

    }

    @Override
    @Transactional(readOnly=true)
    public Order findById(Integer orderId) {
        return repository.findById(orderId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Order> findByCustomer(Integer idCustomer) {
        return repository.findByCustomer(idCustomer);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Order> findAll() {
        return repository.findAll();
    }

}