package com.example.apielgranpollon.controller;

import com.example.apielgranpollon.entity.OrderDetails;
import com.example.apielgranpollon.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/orderdetails")
public class OrderDetailsController {
    @Autowired
    private OrderDetailsService orderService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<OrderDetails> ordersDb=orderService.findAll();

        if(ordersDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(ordersDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody OrderDetails order)
    {
        orderService.insert(order);
        return new ResponseEntity<>("¡OrderDetails registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{orderId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer orderId, @RequestBody OrderDetails order)
    {
        OrderDetails orderDb=orderService.findById(orderId);

        if(orderDb!=null)
        {
            order.setId(orderId);
            orderService.update(order);

            return new ResponseEntity<>("¡OrderDetails editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡OrderDetails no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{orderId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer orderId)
    {
        OrderDetails orderDb=orderService.findById(orderId);

        if(orderDb!=null)
        {
            orderService.delete(orderId);
            return new ResponseEntity<>("¡OrderDetails borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡OrderDetails no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{orderId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer orderId)
    {
        OrderDetails orderDb=orderService.findById(orderId);

        if(orderDb!=null) {
            return new ResponseEntity<>(orderDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡OrderDetails no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/listar/order/{id}")
    public ResponseEntity<?> listar_GET(@PathVariable Integer id)
    {
        OrderDetails orderDb=orderService.findByOrder(id);

        if(orderDb!=null) {
            return new ResponseEntity<>(orderDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡OrderDetails no existe!",HttpStatus.NOT_FOUND);
    }
}
