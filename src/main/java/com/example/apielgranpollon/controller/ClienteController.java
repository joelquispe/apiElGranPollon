package com.example.apielgranpollon.controller;

import com.example.apielgranpollon.entity.Cliente;
import com.example.apielgranpollon.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<Cliente> clienteDb=clienteService.findAll();

        if(clienteDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(clienteDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Cliente cliente)
    {
        clienteService.insert(cliente);
        return new ResponseEntity<>("¡Cliente registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{clienteId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer clienteId, @RequestBody Cliente cliente)
    {
        Cliente clienteDb=clienteService.findById(clienteId);

        if(clienteDb!=null)
        {
            cliente.setId(clienteId);
            clienteService.update(cliente);

            return new ResponseEntity<>("¡Cliente editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Cliente no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{clienteId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer clienteId)
    {
        Cliente clienteDb=clienteService.findById(clienteId);

        if(clienteDb!=null)
        {
            clienteService.delete(clienteId);
            return new ResponseEntity<>("¡Cliente borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Cliente no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{clienteId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer clienteId)
    {
        Cliente clienteDb=clienteService.findById(clienteId);

        if(clienteDb!=null) {
            return new ResponseEntity<>(clienteDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Cliente no existe!",HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/buscar",method = RequestMethod.GET)
    public ResponseEntity<?> buscar_Name_Password(@RequestParam Map<String,String> requestParams){
        String email = requestParams.get("email");
        String password = requestParams.get("password");
        Cliente clienteDb = clienteService.findByEmailAndPassword(email,password);
        if(clienteDb!= null){
            return new ResponseEntity<>(clienteDb,HttpStatus.FOUND);
        }
        return  new ResponseEntity<>("Cliente no existe",HttpStatus.NOT_FOUND);
    }

}