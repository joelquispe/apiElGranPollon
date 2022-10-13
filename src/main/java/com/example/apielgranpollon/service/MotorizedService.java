package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.Motorized;
import java.util.Collection;

public interface MotorizedService {
    //se define los servicios para los controladores
    public abstract void insert(Motorized motorized);
    public abstract void update(Motorized motorized);
    public abstract void delete(Integer motorizedId);
    public abstract Motorized findById(Integer motorizedId);
    public abstract Collection<Motorized> findAll();
}