package com.example.apielgranpollon.service;

import com.example.apielgranpollon.entity.Cliente;
import java.util.Collection;

public interface ClienteService {
    //se define los servicios para los controladores
    public abstract void insert(Cliente cliente);
    public abstract void update(Cliente cliente);
    public abstract void delete(Integer clienteId);
    public abstract Cliente findById(Integer clienteId);
    public abstract Collection<Cliente> findAll();
    public abstract  Cliente findByEmailAndPassword(String email,String password);
}