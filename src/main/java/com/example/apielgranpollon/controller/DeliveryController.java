package com.example.apielgranpollon.controller;


import com.example.apielgranpollon.entity.Delivery;
import com.example.apielgranpollon.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<Delivery> deliverysDb=deliveryService.findAll();

        if(deliverysDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(deliverysDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Delivery delivery)
    {
        deliveryService.insert(delivery);
        return new ResponseEntity<>("¡Delivery registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{deliveryId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer deliveryId, @RequestBody Delivery delivery)
    {
        Delivery deliveryDb=deliveryService.findById(deliveryId);

        if(deliveryDb!=null)
        {
            delivery.setIdDelivery(deliveryId);
            deliveryService.update(delivery);

            return new ResponseEntity<>("¡Delivery editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Delivery no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{deliveryId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer deliveryId)
    {
        Delivery deliveryDb=deliveryService.findById(deliveryId);

        if(deliveryDb!=null)
        {
            deliveryService.delete(deliveryId);
            return new ResponseEntity<>("¡Delivery borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Delivery no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{deliveryId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer deliveryId)
    {
        Delivery deliveryDb=deliveryService.findById(deliveryId);

        if(deliveryDb!=null) {
            return new ResponseEntity<>(deliveryDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Delivery no existe!",HttpStatus.NOT_FOUND);
    }

}