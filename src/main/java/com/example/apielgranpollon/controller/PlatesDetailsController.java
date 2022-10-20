package com.example.apielgranpollon.controller;


import com.example.apielgranpollon.entity.PlatesDetails;
import com.example.apielgranpollon.service.PlatesDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/platesDetails")
public class PlatesDetailsController {
    @Autowired
    private PlatesDetailsService platesDetailsService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<PlatesDetails> platesDetailssDb=platesDetailsService.findAll();

        if(platesDetailssDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(platesDetailssDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody PlatesDetails platesDetails)
    {
        platesDetailsService.insert(platesDetails);
        return new ResponseEntity<>("¡PlatesDetails registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{platesDetailsId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer platesDetailsId, @RequestBody PlatesDetails platesDetails)
    {
        PlatesDetails platesDetailsDb=platesDetailsService.findById(platesDetailsId);

        if(platesDetailsDb!=null)
        {
            platesDetails.setId(platesDetailsId);
            platesDetailsService.update(platesDetails);

            return new ResponseEntity<>("¡PlatesDetails editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡PlatesDetails no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{platesDetailsId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer platesDetailsId)
    {
        PlatesDetails platesDetailsDb=platesDetailsService.findById(platesDetailsId);

        if(platesDetailsDb!=null)
        {
            platesDetailsService.delete(platesDetailsId);
            return new ResponseEntity<>("¡PlatesDetails borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡PlatesDetails no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{platesDetailsId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer platesDetailsId)
    {
        PlatesDetails platesDetailsDb=platesDetailsService.findById(platesDetailsId);

        if(platesDetailsDb!=null) {
            return new ResponseEntity<>(platesDetailsDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡PlatesDetails no existe!",HttpStatus.NOT_FOUND);
    }

}