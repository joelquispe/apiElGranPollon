package com.example.apielgranpollon.controller;

import com.example.apielgranpollon.entity.MotorizedStatus;
import com.example.apielgranpollon.service.MotorizedStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/motorizedStatus")
public class MotorizedStatusController {
    @Autowired
    private MotorizedStatusService motorizedService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<MotorizedStatus> motorizedStatusDb=motorizedService.findAll();

        if(motorizedStatusDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(motorizedStatusDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody MotorizedStatus motorized)
    {
        motorizedService.insert(motorized);
        return new ResponseEntity<>("¡MotorizedStatus registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{motorizedId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer motorizedId, @RequestBody MotorizedStatus motorized)
    {
        MotorizedStatus motorizedDb=motorizedService.findById(motorizedId);

        if(motorizedDb!=null)
        {
            motorized.setId(motorizedId);
            motorizedService.update(motorized);

            return new ResponseEntity<>("¡MotorizedStatus editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡MotorizedStatus no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{motorizedId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer motorizedId)
    {
        MotorizedStatus motorizedDb=motorizedService.findById(motorizedId);

        if(motorizedDb!=null)
        {
            motorizedService.delete(motorizedId);
            return new ResponseEntity<>("¡MotorizedStatus borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡MotorizedStatus no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{motorizedId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer motorizedId)
    {
        MotorizedStatus motorizedDb=motorizedService.findById(motorizedId);

        if(motorizedDb!=null) {
            return new ResponseEntity<>(motorizedDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡MotorizedStatus no existe!",HttpStatus.NOT_FOUND);
    }

}
