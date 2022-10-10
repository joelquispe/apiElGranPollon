package com.example.apielgranpollon.controller;

import com.example.apielgranpollon.entity.Business;
import com.example.apielgranpollon.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/business")
public class BusinessController {
    @Autowired
    private BusinessService businessService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<Business> businesssDb=businessService.findAll();

        if(businesssDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(businesssDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Business business)
    {
        businessService.insert(business);
        return new ResponseEntity<>("¡Business registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{businessId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer businessId, @RequestBody Business business)
    {
        Business businessDb=businessService.findById(businessId);

        if(businessDb!=null)
        {
            business.setId(businessId);
            businessService.update(business);

            return new ResponseEntity<>("¡Business editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Business no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{businessId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer businessId)
    {
        Business businessDb=businessService.findById(businessId);

        if(businessDb!=null)
        {
            businessService.delete(businessId);
            return new ResponseEntity<>("¡Business borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Business no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{businessId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer businessId)
    {
        Business businessDb=businessService.findById(businessId);

        if(businessDb!=null) {
            return new ResponseEntity<>(businessDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Business no existe!",HttpStatus.NOT_FOUND);
    }

}
