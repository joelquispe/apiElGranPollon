package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.Product;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface ProductService {
    //se define los servicios para los controladores
    public abstract void insert(Product product);
    public abstract void update(Product product);
    public abstract void delete(Integer productId);
    public abstract Product findById(Integer productId);
    public abstract Collection<Product> findAll();
    public abstract Collection<Product> findProductByCategory(String category);
}