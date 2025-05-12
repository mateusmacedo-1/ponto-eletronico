package com.mateus.ponto_eletronico.controllers;


import com.mateus.ponto_eletronico.business.UserBC;
import com.mateus.ponto_eletronico.domain.Usuario;
import com.mateus.ponto_eletronico.dto.usuarios.CreateUserRequest;
import com.mateus.ponto_eletronico.dto.usuarios.CreateUserResponse;
import com.mateus.ponto_eletronico.exceptions.business.BusinessException;
import com.mateus.ponto_eletronico.exceptions.business.ConflitoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    private final UserBC userBC;
    public UsuariosController(UserBC userBC) {
        this.userBC = userBC;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable int id){
        Usuario usuario = userBC.getById(id);
        return ResponseEntity.status(200).body(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(){
        List<Usuario> usuarios = userBC.getAll();
        return ResponseEntity.status(200).body(usuarios);
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest userDto){
        try {
            Usuario usuario = new Usuario(userDto);
            int newId = userBC.createUser(usuario);
            return ResponseEntity.status(201).body(new CreateUserResponse(newId));
        } catch (BusinessException e){
            return ResponseEntity.status(422).body(new CreateUserResponse(0, e.getMessage()));
        } catch (ConflitoException e){
            return ResponseEntity.status(409).body(new CreateUserResponse(0, e.getMessage()));
        }
    }
}
