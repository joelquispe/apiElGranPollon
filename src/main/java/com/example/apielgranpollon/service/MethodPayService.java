package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.MethodPay;

import java.util.Collection;

public interface MethodPayService {
    //se define los servicios para los controladores
    public abstract void insert(MethodPay methodPay);
    public abstract void update(MethodPay methodPay);
    public abstract void delete(Integer methodPayId);
    public abstract MethodPay findById(Integer methodPayId);
    public abstract Collection<MethodPay> findAll();
}