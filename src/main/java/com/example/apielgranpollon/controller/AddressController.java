package com.example.apielgranpollon.controller;


import com.example.apielgranpollon.entity.Address;
import com.example.apielgranpollon.entity.CreditCard;
import com.example.apielgranpollon.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<Address> addresssDb=addressService.findAll();

        if(addresssDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(addresssDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Address address)
    {
        addressService.insert(address);
        return new ResponseEntity<>("¡Address registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{addressId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer addressId, @RequestBody Address address)
    {
        Address addressDb=addressService.findById(addressId);

        if(addressDb!=null)
        {
            address.setIdAddress(addressId);
            addressService.update(address);

            return new ResponseEntity<>("¡Address editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Address no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{addressId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer addressId)
    {
        Address addressDb=addressService.findById(addressId);

        if(addressDb!=null)
        {
            addressService.delete(addressId);
            return new ResponseEntity<>("¡Address borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Address no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{addressId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer addressId)
    {
        Address addressDb=addressService.findById(addressId);

        if(addressDb!=null) {
            return new ResponseEntity<>(addressDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Address no existe!",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/listar/customer/{id}")
    public ResponseEntity<?> listar_GET(@PathVariable Integer id)
    {
        Collection<Address> addressDb=addressService.findByCustomer(id);

        if(addressDb.isEmpty()) {
            return new ResponseEntity<>(new ArrayList() ,HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(addressDb,HttpStatus.OK);
    }

}