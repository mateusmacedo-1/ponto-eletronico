package com.mateus.ponto_eletronico.dao;

import com.mateus.ponto_eletronico.domain.Configuracoes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigDAOJPA implements ConfigDAO{
    private ConfigRepository repository;

    public ConfigDAOJPA(ConfigRepository repository){
        this.repository = repository;
    }

    @Override
    public Configuracoes getLast() {
        return repository.findTopByOrderByTimestampDesc();
    }

    @Override
    public int create(Configuracoes config) {
        var created = repository.save(config);
        return created.getId();
    }

    @Override
    public List<Configuracoes> getAll() {
        return repository.findAll();
    }
}
