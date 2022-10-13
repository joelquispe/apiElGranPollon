package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.Order;
import java.util.Collection;

public interface OrderService {
    //se define los servicios para los controladores
    public abstract void insert(Order order);
    public abstract void update(Order order);
    public abstract void delete(Integer orderId);
    public abstract Order findById(Integer orderId);
    public abstract Collection<Order> findAll();
}