package com.example.apielgranpollon.service;


import java.util.Collection;

import com.example.apielgranpollon.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apielgranpollon.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository repository;

    @Override
    @Transactional
    public void insert(Cart cart) {
        repository.save(cart);
    }

    @Override
    @Transactional
    public void update(Cart cart) {
        repository.save(cart);
    }

    @Override
    @Transactional
    public void delete(Integer shoppingCartId) {
        repository.deleteById(shoppingCartId);

    }

    @Override
    @Transactional(readOnly=true)
    public Cart findById(Integer shoppingCartId) {
        return repository.findById(shoppingCartId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Cart> findAll() {
        return repository.findAll();
    }

}
