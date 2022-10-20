package com.example.apielgranpollon.service;


import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apielgranpollon.entity.ShoppingCart;
import com.example.apielgranpollon.repository.ShoppingCartRepository;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

    @Autowired
    private ShoppingCartRepository repository;

    @Override
    @Transactional
    public void insert(ShoppingCart shoppingCart) {
        repository.save(shoppingCart);
    }

    @Override
    @Transactional
    public void update(ShoppingCart shoppingCart) {
        repository.save(shoppingCart);
    }

    @Override
    @Transactional
    public void delete(Integer shoppingCartId) {
        repository.deleteById(shoppingCartId);

    }

    @Override
    @Transactional(readOnly=true)
    public ShoppingCart findById(Integer shoppingCartId) {
        return repository.findById(shoppingCartId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<ShoppingCart> findAll() {
        return repository.findAll();
    }

}
