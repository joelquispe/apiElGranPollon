package com.example.apielgranpollon.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apielgranpollon.entity.Product;
import com.example.apielgranpollon.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Override
    @Transactional
    public void insert(Product product) {
        repository.save(product);
    }

    @Override
    @Transactional
    public void update(Product product) {
        repository.save(product);
    }

    @Override
    @Transactional
    public void delete(Integer productId) {
        repository.deleteById(productId);

    }

    @Override
    @Transactional(readOnly=true)
    public Product findById(Integer productId) {
        return repository.findById(productId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Product> findAll() {
        return repository.findAll();
    }

}