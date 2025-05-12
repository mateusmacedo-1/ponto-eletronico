package com.mateus.ponto_eletronico.controllers;


import com.mateus.ponto_eletronico.business.ConfigBC;
import com.mateus.ponto_eletronico.business.PontoBC;
import com.mateus.ponto_eletronico.business.UserBC;
import com.mateus.ponto_eletronico.dao.ConfigDAO;
import com.mateus.ponto_eletronico.dao.UserDAO;
import com.mateus.ponto_eletronico.domain.Configuracoes;
import com.mateus.ponto_eletronico.domain.Ponto;
import com.mateus.ponto_eletronico.domain.TipoPonto;
import com.mateus.ponto_eletronico.domain.Usuario;
import com.mateus.ponto_eletronico.dto.pontos.RegistrarPontoRequest;
import com.mateus.ponto_eletronico.dto.pontos.RegistrarPontoResponse;
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
    public ResponseEntity<RegistrarPontoResponse> registrar(@RequestBody RegistrarPontoRequest dto){
        Ponto ponto = pontoBC.registrarPonto(dto.usuarioId());
        return ResponseEntity.status(200).body(new RegistrarPontoResponse(ponto));
    }
}
