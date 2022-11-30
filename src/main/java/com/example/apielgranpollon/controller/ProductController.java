package com.example.apielgranpollon.controller;

import com.example.apielgranpollon.entity.Product;
import com.example.apielgranpollon.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/plates")
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<Product> platessDb=productService.findAll();

        if(platessDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(platessDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Product product)
    {
        productService.insert(product);
        return new ResponseEntity<>("¡Product registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{platesId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer platesId, @RequestBody Product product)
    {
        Product productDb =productService.findById(platesId);

        if(productDb !=null)
        {
            product.setId(platesId);
            productService.update(product);

            return new ResponseEntity<>("¡Product editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Product no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{platesId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer platesId)
    {
        Product productDb =productService.findById(platesId);

        if(productDb !=null)
        {
            productService.delete(platesId);
            return new ResponseEntity<>("¡Product borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Product no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{platesId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer platesId)
    {
        Product productDb =productService.findById(platesId);

        if(productDb !=null) {
            return new ResponseEntity<>(productDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Product no existe!",HttpStatus.NOT_FOUND);
    }

}