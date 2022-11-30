package com.example.apielgranpollon.service;

import java.util.Collection;

import com.example.apielgranpollon.entity.LineaOrden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apielgranpollon.repository.LineaOrdenRepository;

@Service
public class LineaOrdenServiceImpl implements LineaOrdenService {

    @Autowired
    private LineaOrdenRepository repository;

    @Override
    @Transactional
    public void insert(LineaOrden lineaOrden) {
        repository.save(lineaOrden);
    }

    @Override
    @Transactional
    public void update(LineaOrden lineaOrden) {
        repository.save(lineaOrden);
    }

    @Override
    @Transactional
    public void delete(Integer lineaOrdenId) {
        repository.deleteById(lineaOrdenId);

    }

    @Override
    @Transactional(readOnly=true)
    public LineaOrden findById(Integer lineaOrdenId) {
        return repository.findById(lineaOrdenId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<LineaOrden> findAll() {
        return repository.findAll();
    }

}
