package com.example.apielgranpollon.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apielgranpollon.entity.Rol;
import com.example.apielgranpollon.repository.RolRepository;

@Service
public class RolServiceImpl implements RolService{

    @Autowired
    private RolRepository repository;

    @Override
    @Transactional
    public void insert(Rol rol) {
        repository.save(rol);
    }

    @Override
    @Transactional
    public void update(Rol rol) {
        repository.save(rol);
    }

    @Override
    @Transactional
    public void delete(Integer rolId) {
        repository.deleteById(rolId);

    }

    @Override
    @Transactional(readOnly=true)
    public Rol findById(Integer rolId) {
        return repository.findById(rolId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Rol> findAll() {
        return repository.findAll();
    }

}