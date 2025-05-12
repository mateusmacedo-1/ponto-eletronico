package com.mateus.ponto_eletronico.dao;

import com.mateus.ponto_eletronico.domain.Ponto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDateTime;
import java.util.List;

public interface PontoRepository extends JpaRepository<Ponto, Integer> {

    List<Ponto> findByUsuarioIdAndTimestampBetweenOrderByTimestampDesc(int usuarioId, LocalDateTime inicio, LocalDateTime fim);
}
