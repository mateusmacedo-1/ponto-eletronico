package com.mateus.ponto_eletronico.dao;

import com.mateus.ponto_eletronico.domain.Configuracoes;

import java.util.List;

public interface ConfigDAO {
    Configuracoes getLast();
    int create(Configuracoes config);
    List<Configuracoes> getAll();
}
