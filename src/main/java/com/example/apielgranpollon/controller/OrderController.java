package com.example.apielgranpollon.controller;

import com.example.apielgranpollon.entity.Order;
import com.example.apielgranpollon.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<Order> ordersDb=orderService.findAll();

        if(ordersDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(ordersDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Order order)
    {
        orderService.insert(order);
        return new ResponseEntity<>("¡Order registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{orderId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer orderId, @RequestBody Order order)
    {
        Order orderDb=orderService.findById(orderId);

        if(orderDb!=null)
        {
            order.setId(orderId);
            orderService.update(order);

            return new ResponseEntity<>("¡Order editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Order no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{orderId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer orderId)
    {
        Order orderDb=orderService.findById(orderId);

        if(orderDb!=null)
        {
            orderService.delete(orderId);
            return new ResponseEntity<>("¡Order borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Order no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{orderId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer orderId)
    {
        Order orderDb=orderService.findById(orderId);

        if(orderDb!=null) {
            return new ResponseEntity<>(orderDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Order no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/listar/customer/{id}")
    public ResponseEntity<?> listar_GET(@PathVariable Integer id)
    {
        Collection<Order> orderDb=orderService.findByCustomer(id);

        if(orderDb.isEmpty()) {
            return new ResponseEntity<>("Lista vacía",HttpStatus.FOUND);
        }

        return new ResponseEntity<>(orderDb,HttpStatus.NOT_FOUND);
    }

}