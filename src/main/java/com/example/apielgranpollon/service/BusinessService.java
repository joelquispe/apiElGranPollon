package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.Business;
import java.util.Collection;

public interface BusinessService {
    //se define los servicios para los controladores
    public abstract void insert(Business businness);
    public abstract void update(Business businness);
    public abstract void delete(Integer businnessId);
    public abstract Business findById(Integer businnessId);
    public abstract Collection<Business> findAll();
}