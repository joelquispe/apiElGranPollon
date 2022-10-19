package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.Employe;
import java.util.Collection;

public interface EmployeService {
    //se define los servicios para los controladores
    public abstract void insert(Employe employe);
    public abstract void update(Employe employe);
    public abstract void delete(Integer employeId);
    public abstract Employe findById(Integer employeId);
    public abstract Collection<Employe> findAll();
}