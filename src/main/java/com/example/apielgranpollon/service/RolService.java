package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.Rol;
import java.util.Collection;

public interface RolService {
    //se define los servicios para los controladores
    public abstract void insert(Rol rol);
    public abstract void update(Rol rol);
    public abstract void delete(Integer rolId);
    public abstract Rol findById(Integer rolId);
    public abstract Collection<Rol> findAll();
}