package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.PlatesDetails;
import java.util.Collection;

public interface PlatesDetailsService {
    //se define los servicios para los controladores
    public abstract void insert(PlatesDetails platesDetails);
    public abstract void update(PlatesDetails platesDetails);
    public abstract void delete(Integer platesDetailsId);
    public abstract PlatesDetails findById(Integer platesDetailsId);
    public abstract Collection<PlatesDetails> findAll();
}