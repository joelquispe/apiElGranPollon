package com.example.apielgranpollon.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apielgranpollon.entity.Category;
import com.example.apielgranpollon.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepository repository;

    @Override
    @Transactional
    public void insert(Category category) {
        repository.save(category);
    }

    @Override
    @Transactional
    public void update(Category category) {
        repository.save(category);
    }

    @Override
    @Transactional
    public void delete(Integer categoryId) {
        repository.deleteById(categoryId);

    }

    @Override
    @Transactional(readOnly=true)
    public Category findById(Integer categoryId) {
        return repository.findById(categoryId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Category> findAll() {
        return repository.findAll();
    }

}
