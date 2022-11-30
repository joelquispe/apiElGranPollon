package com.example.apielgranpollon.service;

import java.util.Collection;

import com.example.apielgranpollon.entity.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.apielgranpollon.repository.CreditCardRepository;

@Service
public class CreditCardServiceImpl implements CreditCardService {

    @Autowired
    private CreditCardRepository repository;

    @Override
    @Transactional
    public void insert(CreditCard creditCard) {
        repository.save(creditCard);
    }

    @Override
    @Transactional
    public void update(CreditCard creditCard) {
        repository.save(creditCard);
    }

    @Override
    @Transactional
    public void delete(Integer creditCardId) {
        repository.deleteById(creditCardId);

    }

    @Override
    @Transactional(readOnly=true)
    public CreditCard findById(Integer creditCardId) {
        return repository.findById(creditCardId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<CreditCard> findAll() {
        return repository.findAll();
    }

}
