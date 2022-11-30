package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.LineaOrden;

import java.util.Collection;

public interface LineaOrdenService {
    //se define los servicios para los controladores
    public abstract void insert(LineaOrden lineaOrden);
    public abstract void update(LineaOrden lineaOrden);
    public abstract void delete(Integer lineaOrdenId);
    public abstract LineaOrden findById(Integer lineaOrdenId);
    public abstract Collection<LineaOrden> findAll();
}