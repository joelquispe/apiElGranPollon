package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.Address;

import java.util.Collection;

public interface AddressService {
    //se define los servicios para los controladores
    public abstract void insert(Address address);
    public abstract void update(Address address);
    public abstract void delete(Integer addressId);
    public abstract Address findById(Integer addressId);
    public abstract Collection<Address> findAll();
}