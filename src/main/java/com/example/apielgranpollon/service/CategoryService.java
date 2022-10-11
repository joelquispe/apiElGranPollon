package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.Category;
import java.util.Collection;

public interface CategoryService {
    //se define los servicios para los controladores
    public abstract void insert(Category category);
    public abstract void update(Category category);
    public abstract void delete(Integer categoryId);
    public abstract Category findById(Integer categoryId);
    public abstract Collection<Category> findAll();
}