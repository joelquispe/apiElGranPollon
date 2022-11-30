package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.PaymentDetails;

import java.util.Collection;

public interface PaymentDetailsService {
    //se define los servicios para los controladores
    public abstract void insert(PaymentDetails paymentDetails);
    public abstract void update(PaymentDetails paymentDetails);
    public abstract void delete(Integer paymentDetailsId);
    public abstract PaymentDetails findById(Integer paymentDetailsId);
    public abstract Collection<PaymentDetails> findAll();
}