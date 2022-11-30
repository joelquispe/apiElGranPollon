package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.Cart;

import java.util.Collection;

public interface CartService {
    //se define los servicios para los controladores
    public abstract void insert(Cart cart);
    public abstract void update(Cart cart);
    public abstract void delete(Integer shoppingCartId);
    public abstract Cart findById(Integer shoppingCartId);
    public abstract Collection<Cart> findAll();
}