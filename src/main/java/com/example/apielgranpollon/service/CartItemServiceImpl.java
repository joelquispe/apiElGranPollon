package com.example.apielgranpollon.service;


import java.util.Collection;

import com.example.apielgranpollon.entity.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apielgranpollon.repository.CartItemRepository;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository repository;

    @Override
    @Transactional
    public void insert(CartItem cartItem) {
        repository.save(cartItem);
    }

    @Override
    @Transactional
    public void update(CartItem cartItem) {
        repository.save(cartItem);
    }

    @Override
    @Transactional
    public void delete(Integer CartItemId) {
        repository.deleteById(CartItemId);

    }

    @Override
    @Transactional(readOnly=true)
    public CartItem findById(Integer CartItemId) {
        return repository.findById(CartItemId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<CartItem> findAll() {
        return repository.findAll();
    }

}
