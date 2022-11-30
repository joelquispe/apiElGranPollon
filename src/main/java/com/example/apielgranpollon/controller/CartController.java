package com.example.apielgranpollon.controller;


import com.example.apielgranpollon.entity.Cart;
import com.example.apielgranpollon.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<Cart> cartsDb=cartService.findAll();

        if(cartsDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(cartsDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Cart cart)
    {
        cartService.insert(cart);
        return new ResponseEntity<>("¡Cart registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{cartId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer cartId, @RequestBody Cart cart)
    {
        Cart cartDb=cartService.findById(cartId);

        if(cartDb!=null)
        {
            cart.setId(cartId);
            cartService.update(cart);

            return new ResponseEntity<>("¡Cart editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Cart no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{cartId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer cartId)
    {
        Cart cartDb=cartService.findById(cartId);

        if(cartDb!=null)
        {
            cartService.delete(cartId);
            return new ResponseEntity<>("¡Cart borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Cart no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{cartId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer cartId)
    {
        Cart cartDb=cartService.findById(cartId);

        if(cartDb!=null) {
            return new ResponseEntity<>(cartDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Cart no existe!",HttpStatus.NOT_FOUND);
    }

}