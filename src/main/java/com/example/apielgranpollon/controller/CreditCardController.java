package com.example.apielgranpollon.controller;


import com.example.apielgranpollon.entity.Cart;
import com.example.apielgranpollon.entity.CreditCard;
import com.example.apielgranpollon.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/creditCard")
public class CreditCardController {
    @Autowired
    private CreditCardService creditCardService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<CreditCard> creditCardsDb=creditCardService.findAll();

        if(creditCardsDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(creditCardsDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody CreditCard creditCard)
    {
        creditCardService.insert(creditCard);
        return new ResponseEntity<>("¡CreditCard registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{creditCardId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer creditCardId, @RequestBody CreditCard creditCard)
    {
        CreditCard creditCardDb=creditCardService.findById(creditCardId);

        if(creditCardDb!=null)
        {
            creditCard.setIdCreditCard(creditCardId);
            creditCardService.update(creditCard);

            return new ResponseEntity<>("¡CreditCard editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡CreditCard no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{creditCardId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer creditCardId)
    {
        CreditCard creditCardDb=creditCardService.findById(creditCardId);

        if(creditCardDb!=null)
        {
            creditCardService.delete(creditCardId);
            return new ResponseEntity<>("¡CreditCard borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡CreditCard no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{creditCardId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer creditCardId)
    {
        CreditCard creditCardDb=creditCardService.findById(creditCardId);

        if(creditCardDb!=null) {
            return new ResponseEntity<>(creditCardDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡CreditCard no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/listar/customer/{id}")
    public ResponseEntity<?> listar_GET(@PathVariable Integer id)
    {
        Collection<CreditCard> cardDb=creditCardService.findByCustomer(id);

        if(cardDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(cardDb,HttpStatus.OK);
    }

}