package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.ShoppingCart;
import java.util.Collection;

public interface ShoppingCartService {
    //se define los servicios para los controladores
    public abstract void insert(ShoppingCart shoppingCart);
    public abstract void update(ShoppingCart shoppingCart);
    public abstract void delete(Integer shoppingCartId);
    public abstract ShoppingCart findById(Integer shoppingCartId);
    public abstract Collection<ShoppingCart> findAll();
}