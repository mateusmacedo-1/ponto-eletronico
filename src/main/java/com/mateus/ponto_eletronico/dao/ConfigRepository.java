package com.mateus.ponto_eletronico.dao;

import com.mateus.ponto_eletronico.domain.Configuracoes;
import com.mateus.ponto_eletronico.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigRepository extends JpaRepository<Configuracoes, Integer> {
    Configuracoes findTopByOrderByTimestampDesc();
}
