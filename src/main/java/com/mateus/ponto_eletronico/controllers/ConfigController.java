package com.mateus.ponto_eletronico.controllers;


import com.mateus.ponto_eletronico.business.ConfigBC;
import com.mateus.ponto_eletronico.domain.Configuracoes;
import com.mateus.ponto_eletronico.dto.CreateConfigRequest;
import com.mateus.ponto_eletronico.dto.CreateConfigResponse;
import com.mateus.ponto_eletronico.dto.GenericResponse;
import com.mateus.ponto_eletronico.exceptions.business.BusinessException;
import com.mateus.ponto_eletronico.exceptions.business.ConflitoException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/config")
public class ConfigController {
    private ConfigBC configBC;

    public ConfigController(ConfigBC configBC) {
        this.configBC = configBC;
    }

    @PostMapping
    public ResponseEntity<GenericResponse> add(@RequestBody CreateConfigRequest dto){
        try {
            Configuracoes config = new Configuracoes(dto);
            int newId = configBC.create(config);
            return ResponseEntity.status(201).body(new CreateConfigResponse(newId));
        } catch (BusinessException e){
            return ResponseEntity.status(422).body(new CreateConfigResponse(0, e.getMessage()));
        } catch (ConflitoException e){
            return ResponseEntity.status(409).body(new CreateConfigResponse(0, e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity get(@RequestParam(required = false) boolean current){
        if (current) {
            return ResponseEntity.status(200).body(configBC.getCurrent());
        }
        return ResponseEntity.status(200).body(configBC.getAll());
    }
}
