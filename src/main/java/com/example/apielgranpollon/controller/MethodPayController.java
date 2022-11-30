package com.example.apielgranpollon.controller;


import com.example.apielgranpollon.entity.MethodPay;
import com.example.apielgranpollon.service.MethodPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/methodPay")
public class MethodPayController {
    @Autowired
    private MethodPayService methodPayService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<MethodPay> methodPaysDb=methodPayService.findAll();

        if(methodPaysDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(methodPaysDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody MethodPay methodPay)
    {
        methodPayService.insert(methodPay);
        return new ResponseEntity<>("¡MethodPay registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{methodPayId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer methodPayId, @RequestBody MethodPay methodPay)
    {
        MethodPay methodPayDb=methodPayService.findById(methodPayId);

        if(methodPayDb!=null)
        {
            methodPay.setIdMethodpay(methodPayId);
            methodPayService.update(methodPay);

            return new ResponseEntity<>("¡MethodPay editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡MethodPay no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{methodPayId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer methodPayId)
    {
        MethodPay methodPayDb=methodPayService.findById(methodPayId);

        if(methodPayDb!=null)
        {
            methodPayService.delete(methodPayId);
            return new ResponseEntity<>("¡MethodPay borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡MethodPay no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{methodPayId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer methodPayId)
    {
        MethodPay methodPayDb=methodPayService.findById(methodPayId);

        if(methodPayDb!=null) {
            return new ResponseEntity<>(methodPayDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡MethodPay no existe!",HttpStatus.NOT_FOUND);
    }

}