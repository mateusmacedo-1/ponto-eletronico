package com.mateus.ponto_eletronico.controllers;


import com.mateus.ponto_eletronico.business.PontoBC;
import com.mateus.ponto_eletronico.domain.Ponto;
import com.mateus.ponto_eletronico.dto.GenericResponse;
import com.mateus.ponto_eletronico.dto.pontos.RegistrarPontoRequest;
import com.mateus.ponto_eletronico.dto.pontos.RegistrarPontoResponse;
import com.mateus.ponto_eletronico.exceptions.business.BusinessException;
import com.mateus.ponto_eletronico.exceptions.business.ConflitoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pontos")
public class PontoController {
    private final PontoBC pontoBC;

    public PontoController(PontoBC pontoBC) {
        this.pontoBC = pontoBC;
    }

    @PostMapping
    public ResponseEntity<GenericResponse> registrar(@RequestBody RegistrarPontoRequest dto){
        try {
            Ponto ponto = pontoBC.registrarPonto(dto.usuarioId());
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
