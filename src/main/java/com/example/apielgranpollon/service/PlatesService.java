package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.Plates;
import java.util.Collection;

public interface PlatesService {
    //se define los servicios para los controladores
    public abstract void insert(Plates plates);
    public abstract void update(Plates plates);
    public abstract void delete(Integer platesId);
    public abstract Plates findById(Integer platesId);
    public abstract Collection<Plates> findAll();
}