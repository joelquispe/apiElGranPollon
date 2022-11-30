package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.CartItem;

import java.util.Collection;

public interface CartItemService {
    //se define los servicios para los controladores
    public abstract void insert(CartItem cartItem);
    public abstract void update(CartItem cartItem);
    public abstract void delete(Integer CartItemId);
    public abstract CartItem findById(Integer CartItemId);
    public abstract Collection<CartItem> findAll();
}