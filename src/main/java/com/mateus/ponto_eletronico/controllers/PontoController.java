package com.mateus.ponto_eletronico.controllers;


import com.mateus.ponto_eletronico.business.PontoBC;
import com.mateus.ponto_eletronico.domain.Ponto;
import com.mateus.ponto_eletronico.dto.GenericResponse;
import com.mateus.ponto_eletronico.dto.pontos.RegistrarPontoResponse;
import com.mateus.ponto_eletronico.exceptions.business.BusinessException;
import com.mateus.ponto_eletronico.exceptions.business.ConflitoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios/{id}/pontos")
public class PontoController {
    private final PontoBC pontoBC;

    public PontoController(PontoBC pontoBC) {
        this.pontoBC = pontoBC;
    }

    @PostMapping
    public ResponseEntity<GenericResponse> registrar(@PathVariable int id){
        try {
            Ponto ponto = pontoBC.registrarPonto(id);
            return ResponseEntity.status(201).body(new RegistrarPontoResponse(ponto));
        } catch (BusinessException e){
            String errorMsg = String.format(RegistrarPontoResponse.CREATE_MESSAGE_ERROR, e.getMessage());
            return ResponseEntity.status(422).body(new GenericResponse(errorMsg));
        } catch (ConflitoException e){
            String errorMsg = String.format(RegistrarPontoResponse.CREATE_MESSAGE_ERROR, e.getMessage());
            return ResponseEntity.status(409).body(new GenericResponse(errorMsg));
        }
    }

}
