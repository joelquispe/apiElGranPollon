package com.example.apielgranpollon.controller;

import com.example.apielgranpollon.entity.Cliente;
import com.example.apielgranpollon.entity.Motorized;
import com.example.apielgranpollon.service.MotorizedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/motorized")
public class MotorizedController {
    @Autowired
    private MotorizedService motorizedService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<Motorized> motorizedDb=motorizedService.findAll();

        if(motorizedDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(motorizedDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Motorized motorized)
    {
        motorizedService.insert(motorized);
        return new ResponseEntity<>("¡Motorized registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{motorizedId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer motorizedId, @RequestBody Motorized motorized)
    {
        Motorized motorizedDb=motorizedService.findById(motorizedId);

        if(motorizedDb!=null)
        {
            motorized.setId(motorizedId);
            motorizedService.update(motorized);

            return new ResponseEntity<>("¡Motorized editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Motorized no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{motorizedId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer motorizedId)
    {
        Motorized motorizedDb=motorizedService.findById(motorizedId);

        if(motorizedDb!=null)
        {
            motorizedService.delete(motorizedId);
            return new ResponseEntity<>("¡Motorized borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Motorized no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{motorizedId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer motorizedId)
    {
        Motorized motorizedDb=motorizedService.findById(motorizedId);

        if(motorizedDb!=null) {
            return new ResponseEntity<>(motorizedDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Motorized no existe!",HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/buscar",method = RequestMethod.POST)
    public ResponseEntity<?> buscar_Name_Password(@RequestParam Map<String,String> requestParams){
        String email = requestParams.get("email");
        String password = requestParams.get("password");
        Motorized motorizedDb = motorizedService.findByEmailAndPassword(email,password);
        if(motorizedDb!= null){
            return new ResponseEntity<>(motorizedDb,HttpStatus.FOUND);
        }
        return  new ResponseEntity<>("Cliente no existe",HttpStatus.NOT_FOUND);
    }

}
