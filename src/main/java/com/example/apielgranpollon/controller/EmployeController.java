package com.example.apielgranpollon.controller;


import com.example.apielgranpollon.entity.Employe;
import com.example.apielgranpollon.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employe")
public class EmployeController {
    @Autowired
    private EmployeService employeService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<Employe> employeDb=employeService.findAll();

        if(employeDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(employeDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Employe employe)
    {
        employeService.insert(employe);
        return new ResponseEntity<>("¡Employe registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{employeId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer employeId, @RequestBody Employe employe)
    {
        Employe employeDb=employeService.findById(employeId);

        if(employeDb!=null)
        {
            employe.setId(employeId);
            employeService.update(employe);

            return new ResponseEntity<>("¡Employe editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Employe no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{employeId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer employeId)
    {
        Employe employeDb=employeService.findById(employeId);

        if(employeDb!=null)
        {
            employeService.delete(employeId);
            return new ResponseEntity<>("¡Employe borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Employe no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{employeId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer employeId)
    {
        Employe employeDb=employeService.findById(employeId);

        if(employeDb!=null) {
            return new ResponseEntity<>(employeDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Employe no existe!",HttpStatus.NOT_FOUND);
    }

}