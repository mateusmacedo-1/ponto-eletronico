package com.mateus.ponto_eletronico.dao;

import com.mateus.ponto_eletronico.domain.Configuracoes;
import com.mateus.ponto_eletronico.domain.Ponto;
import com.mateus.ponto_eletronico.domain.TipoPonto;
import com.mateus.ponto_eletronico.domain.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class PontoDAOJPA implements PontoDAO{

    private final PontoRepository repository;

    public PontoDAOJPA(PontoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Ponto registrarPonto(Usuario usuario, TipoPonto tipoPonto, Configuracoes config) {
        var ponto = new Ponto(tipoPonto, usuario, config);
        return repository.save(ponto);
    }

    @Override
    public Optional<Ponto> getUltimoPontoUsuario(int usuarioId) {
        var inicio = LocalDate.now().atTime(LocalTime.MIN);
        var fim = LocalDate.now().atTime(LocalTime.MAX);
        List<Ponto> listUltimoPonto = repository.findByUsuarioIdAndTimestampBetweenOrderByTimestampDesc(usuarioId, inicio, fim);
        Optional<Ponto> optUltimoPonto = listUltimoPonto.stream().findFirst();
        return optUltimoPonto;
    }
}
