package com.example.apielgranpollon.controller;


import com.example.apielgranpollon.entity.LineaOrden;
import com.example.apielgranpollon.service.LineaOrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/lineaorden")
public class LineaOrdenController {
    @Autowired
    private LineaOrdenService lineaordenService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<LineaOrden> lineaordensDb=lineaordenService.findAll();

        if(lineaordensDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(lineaordensDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody LineaOrden lineaorden)
    {
        lineaordenService.insert(lineaorden);
        return new ResponseEntity<>("¡LineaOrden registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{lineaordenId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer lineaordenId, @RequestBody LineaOrden lineaorden)
    {
        LineaOrden lineaordenDb=lineaordenService.findById(lineaordenId);

        if(lineaordenDb!=null)
        {
            lineaorden.setIdLineadeOrden(lineaordenId);
            lineaordenService.update(lineaorden);

            return new ResponseEntity<>("¡LineaOrden editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡LineaOrden no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{lineaordenId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer lineaordenId)
    {
        LineaOrden lineaordenDb=lineaordenService.findById(lineaordenId);

        if(lineaordenDb!=null)
        {
            lineaordenService.delete(lineaordenId);
            return new ResponseEntity<>("¡LineaOrden borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡LineaOrden no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{lineaordenId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer lineaordenId)
    {
        LineaOrden lineaordenDb=lineaordenService.findById(lineaordenId);

        if(lineaordenDb!=null) {
            return new ResponseEntity<>(lineaordenDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡LineaOrden no existe!",HttpStatus.NOT_FOUND);
    }

}