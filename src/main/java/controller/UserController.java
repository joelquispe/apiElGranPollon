package controller;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.Collection;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/listar")
    public ResponseEntity<?> listar_GET()
    {
        Collection<User> usersDb=userService.findAll();

        if(usersDb.isEmpty()) {
            return new ResponseEntity<>("¡Lista vacía!", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(usersDb,HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<?> registrar_POST(@RequestBody User user)
    {
        userService.insert(user);
        return new ResponseEntity<>("¡User registrado!",HttpStatus.CREATED);
    }

    @PutMapping("/editar/{userId}")
    public ResponseEntity<?> editar_PUT(@PathVariable Integer userId,@RequestBody User user)
    {
        User userDb=userService.findById(userId);

        if(userDb!=null)
        {
            user.setId(userId);
            userService.update(user);

            return new ResponseEntity<>("¡User editado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡User no existe!",HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/borrar/{userId}")
    public ResponseEntity<?> borrar_DELETE(@PathVariable Integer userId)
    {
        User userDb=userService.findById(userId);

        if(userDb!=null)
        {
            userService.delete(userId);
            return new ResponseEntity<>("¡User borrado!",HttpStatus.OK);
        }

        return new ResponseEntity<>("¡User no existe!",HttpStatus.NOT_FOUND);
    }

    @GetMapping("/buscar/{userId}")
    public ResponseEntity<?> buscar_GET(@PathVariable Integer userId)
    {
        User userDb=userService.findById(userId);

        if(userDb!=null) {
            return new ResponseEntity<>(userDb,HttpStatus.FOUND);
        }

        return new ResponseEntity<>("¡User no existe!",HttpStatus.NOT_FOUND);
    }
}
