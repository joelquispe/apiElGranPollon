package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.Delivery;

import java.util.Collection;

public interface DeliveryService {
    //se define los servicios para los controladores
    public abstract void insert(Delivery delivery);
    public abstract void update(Delivery delivery);
    public abstract void delete(Integer deliveryId);
    public abstract Delivery findById(Integer deliveryId);
    public abstract Collection<Delivery> findAll();
}
