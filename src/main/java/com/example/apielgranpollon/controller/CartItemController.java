package com.example.apielgranpollon.controller;


import com.example.apielgranpollon.entity.CartItem;
import com.example.apielgranpollon.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {
    @Autowired
    private CartItemService CartItemService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<CartItem> CartItemsDb=CartItemService.findAll();

        if(CartItemsDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(CartItemsDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody CartItem CartItem)
    {
        CartItemService.insert(CartItem);
        return new ResponseEntity<>("¡CartItem registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{CartItemId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer CartItemId, @RequestBody CartItem CartItem)
    {
        CartItem CartItemDb=CartItemService.findById(CartItemId);

        if(CartItemDb!=null)
        {
            CartItem.setIdCartItem(CartItemId);
            CartItemService.update(CartItem);

            return new ResponseEntity<>("¡CartItem editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡CartItem no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{CartItemId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer CartItemId)
    {
        CartItem CartItemDb=CartItemService.findById(CartItemId);

        if(CartItemDb!=null)
        {
            CartItemService.delete(CartItemId);
            return new ResponseEntity<>("¡CartItem borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡CartItem no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{CartItemId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer CartItemId)
    {
        CartItem CartItemDb=CartItemService.findById(CartItemId);

        if(CartItemDb!=null) {
            return new ResponseEntity<>(CartItemDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡CartItem no existe!",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/editar/quantity/{CartItemId}")
    public ResponseEntity<?> editar_quantity(@PathVariable Integer CartItemId, @RequestBody CartItem body)
    {
       CartItemService.editQuantityItem(body.getQuantity(),CartItemId);
        return new ResponseEntity<>("¡CartItem no existe!",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/listar/cart/{cartId}")
    public ResponseEntity<?> listarByCart(@PathVariable Integer cartId)
    {
        Collection<CartItem> CartItemsDb=CartItemService.findByCart(cartId);

        if(CartItemsDb.isEmpty()) {
            return new ResponseEntity<>(new ArrayList(), HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(CartItemsDb,HttpStatus.OK);
    }

}