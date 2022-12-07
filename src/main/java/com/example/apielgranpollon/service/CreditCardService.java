package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.Cart;
import com.example.apielgranpollon.entity.CreditCard;

import java.util.Collection;

public interface CreditCardService {
    //se define los servicios para los controladores
    public abstract void insert(CreditCard creditCard);
    public abstract void update(CreditCard creditCard);
    public abstract void delete(Integer creditCardId);
    public abstract CreditCard findById(Integer creditCardId);
    public abstract Collection<CreditCard> findAll();

    public abstract Collection<CreditCard> findByCustomer(Integer idCustomer);
}