package com.example.apielgranpollon.controller;


import com.example.apielgranpollon.entity.ShoppingCart;
import com.example.apielgranpollon.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<ShoppingCart> shoppingCartsDb=shoppingCartService.findAll();

        if(shoppingCartsDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(shoppingCartsDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody ShoppingCart shoppingCart)
    {
        shoppingCartService.insert(shoppingCart);
        return new ResponseEntity<>("¡ShoppingCart registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{shoppingCartId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer shoppingCartId, @RequestBody ShoppingCart shoppingCart)
    {
        ShoppingCart shoppingCartDb=shoppingCartService.findById(shoppingCartId);

        if(shoppingCartDb!=null)
        {
            shoppingCart.setId(shoppingCartId);
            shoppingCartService.update(shoppingCart);

            return new ResponseEntity<>("¡ShoppingCart editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡ShoppingCart no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{shoppingCartId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer shoppingCartId)
    {
        ShoppingCart shoppingCartDb=shoppingCartService.findById(shoppingCartId);

        if(shoppingCartDb!=null)
        {
            shoppingCartService.delete(shoppingCartId);
            return new ResponseEntity<>("¡ShoppingCart borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡ShoppingCart no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{shoppingCartId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer shoppingCartId)
    {
        ShoppingCart shoppingCartDb=shoppingCartService.findById(shoppingCartId);

        if(shoppingCartDb!=null) {
            return new ResponseEntity<>(shoppingCartDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡ShoppingCart no existe!",HttpStatus.NOT_FOUND);
    }

}