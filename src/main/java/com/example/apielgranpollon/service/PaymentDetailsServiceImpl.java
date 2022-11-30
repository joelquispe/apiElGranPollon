package com.example.apielgranpollon.service;

import java.util.Collection;

import com.example.apielgranpollon.entity.PaymentDetails;
import com.example.apielgranpollon.repository.PaymentDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentDetailsServiceImpl implements PaymentDetailsService {

    @Autowired
    private PaymentDetailsRepository repository;

    @Override
    @Transactional
    public void insert(PaymentDetails paymentDetails) {
        repository.save(paymentDetails);
    }

    @Override
    @Transactional
    public void update(PaymentDetails paymentDetails) {
        repository.save(paymentDetails);
    }

    @Override
    @Transactional
    public void delete(Integer paymentDetailsId) {
        repository.deleteById(paymentDetailsId);

    }

    @Override
    @Transactional(readOnly=true)
    public PaymentDetails findById(Integer paymentDetailsId) {
        return repository.findById(paymentDetailsId).orElse(null);
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<PaymentDetails> findAll() {
        return repository.findAll();
    }

}
