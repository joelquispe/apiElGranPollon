package com.example.apielgranpollon.controller;


import com.example.apielgranpollon.entity.Rol;
import com.example.apielgranpollon.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
    private RolService rolService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<Rol> rolsDb=rolService.findAll();

        if(rolsDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(rolsDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Rol rol)
    {
        rolService.insert(rol);
        return new ResponseEntity<>("¡Rol registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{rolId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer rolId, @RequestBody Rol rol)
    {
        Rol rolDb=rolService.findById(rolId);

        if(rolDb!=null)
        {
            rol.setId(rolId);
            rolService.update(rol);

            return new ResponseEntity<>("¡Rol editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Rol no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{rolId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer rolId)
    {
        Rol rolDb=rolService.findById(rolId);

        if(rolDb!=null)
        {
            rolService.delete(rolId);
            return new ResponseEntity<>("¡Rol borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Rol no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{rolId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer rolId)
    {
        Rol rolDb=rolService.findById(rolId);

        if(rolDb!=null) {
            return new ResponseEntity<>(rolDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Rol no existe!",HttpStatus.NOT_FOUND);
    }

}