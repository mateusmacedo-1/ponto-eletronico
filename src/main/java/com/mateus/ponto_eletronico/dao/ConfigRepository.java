package com.mateus.ponto_eletronico.dao;

import com.mateus.ponto_eletronico.domain.Configuracoes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfigRepository extends JpaRepository<Configuracoes, Integer> {
    Optional<Configuracoes> findTopByOrderByTimestampDesc();

}
