package com.example.apielgranpollon.controller;

import com.example.apielgranpollon.entity.Category;
import com.example.apielgranpollon.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<Category> categorysDb=categoryService.findAll();

        if(categorysDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(categorysDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody Category category)
    {
        categoryService.insert(category);
        return new ResponseEntity<>("¡Category registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{categoryId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer categoryId, @RequestBody Category category)
    {
        Category categoryDb=categoryService.findById(categoryId);

        if(categoryDb!=null)
        {
            category.setId(categoryId);
            categoryService.update(category);

            return new ResponseEntity<>("¡Category editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Category no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{categoryId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer categoryId)
    {
        Category categoryDb=categoryService.findById(categoryId);

        if(categoryDb!=null)
        {
            categoryService.delete(categoryId);
            return new ResponseEntity<>("¡Category borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡Category no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{categoryId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer categoryId)
    {
        Category categoryDb=categoryService.findById(categoryId);

        if(categoryDb!=null) {
            return new ResponseEntity<>(categoryDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡Category no existe!",HttpStatus.NOT_FOUND);
    }

}