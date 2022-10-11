package com.example.apielgranpollon.controller;

import com.example.apielgranpollon.entity.Plates;
import com.example.apielgranpollon.service.PlatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/plates")
public class PlatesController {
    @Autowired
    private PlatesService platesService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<Plates> platessDb=platesService.findAll();

        if(platessDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(platessDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Plates plates)
    {
        platesService.insert(plates);
        return new ResponseEntity<>("¡Plates registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{platesId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer platesId, @RequestBody Plates plates)
    {
        Plates platesDb=platesService.findById(platesId);

        if(platesDb!=null)
        {
            plates.setId(platesId);
            platesService.update(plates);

            return new ResponseEntity<>("¡Plates editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Plates no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{platesId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer platesId)
    {
        Plates platesDb=platesService.findById(platesId);

        if(platesDb!=null)
        {
            platesService.delete(platesId);
            return new ResponseEntity<>("¡Plates borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Plates no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{platesId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer platesId)
    {
        Plates platesDb=platesService.findById(platesId);

        if(platesDb!=null) {
            return new ResponseEntity<>(platesDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Plates no existe!",HttpStatus.NOT_FOUND);
    }

}