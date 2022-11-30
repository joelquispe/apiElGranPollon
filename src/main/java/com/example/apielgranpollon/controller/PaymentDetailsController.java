package com.example.apielgranpollon.controller;


import com.example.apielgranpollon.entity.PaymentDetails;
import com.example.apielgranpollon.service.PaymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/paymentDetails")
public class PaymentDetailsController {
    @Autowired
    private PaymentDetailsService paymentDetailsService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<PaymentDetails> paymentDetailssDb=paymentDetailsService.findAll();

        if(paymentDetailssDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(paymentDetailssDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody PaymentDetails paymentDetails)
    {
        paymentDetailsService.insert(paymentDetails);
        return new ResponseEntity<>("¡PaymentDetails registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{paymentDetailsId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer paymentDetailsId, @RequestBody PaymentDetails paymentDetails)
    {
        PaymentDetails paymentDetailsDb=paymentDetailsService.findById(paymentDetailsId);

        if(paymentDetailsDb!=null)
        {
            paymentDetails.setIdPaymentDetails(paymentDetailsId);
            paymentDetailsService.update(paymentDetails);

            return new ResponseEntity<>("¡PaymentDetails editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡PaymentDetails no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{paymentDetailsId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer paymentDetailsId)
    {
        PaymentDetails paymentDetailsDb=paymentDetailsService.findById(paymentDetailsId);

        if(paymentDetailsDb!=null)
        {
            paymentDetailsService.delete(paymentDetailsId);
            return new ResponseEntity<>("¡PaymentDetails borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡PaymentDetails no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{paymentDetailsId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer paymentDetailsId)
    {
        PaymentDetails paymentDetailsDb=paymentDetailsService.findById(paymentDetailsId);

        if(paymentDetailsDb!=null) {
            return new ResponseEntity<>(paymentDetailsDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡PaymentDetails no existe!",HttpStatus.NOT_FOUND);
    }

}