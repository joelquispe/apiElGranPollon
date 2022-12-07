package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.Order;
import com.example.apielgranpollon.entity.OrderDetails;

import java.util.Collection;

public interface OrderDetailsService {
    public abstract void insert(OrderDetails orderDetails);
    public abstract void update(OrderDetails orderDetails);
    public abstract void delete(Integer orderDetailsId);
    public abstract OrderDetails findById(Integer orderDetailsId);
    public abstract  OrderDetails findByOrder(Integer idOrder);
    public abstract Collection<OrderDetails> findAll();
}
