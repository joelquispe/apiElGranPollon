package com.example.apielgranpollon.service;

import java.util.Collection;

import com.example.apielgranpollon.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apielgranpollon.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository repository;

    @Override
    @Transactional
    public void insert(Address address) {
        repository.save(address);
    }

    @Override
    @Transactional
    public void update(Address address) {
        repository.save(address);
    }

    @Override
    @Transactional
    public void delete(Integer addressId) {
        repository.deleteById(addressId);

    }

    @Override
    @Transactional(readOnly=true)
    public Address findById(Integer addressId) {
        return repository.findById(addressId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<Address> findAll() {
        return repository.findAll();
    }

}
