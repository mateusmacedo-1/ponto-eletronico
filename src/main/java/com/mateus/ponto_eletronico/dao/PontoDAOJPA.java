package com.mateus.ponto_eletronico.dao;

import com.mateus.ponto_eletronico.domain.Configuracoes;
import com.mateus.ponto_eletronico.domain.Ponto;
import com.mateus.ponto_eletronico.domain.TipoPonto;
import com.mateus.ponto_eletronico.domain.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class PontoDAOJPA implements PontoDAO{

    private final PontoRepository repository;
    private final UserRepository userRepository;
    private final ConfigRepository configRepository;

    public PontoDAOJPA(PontoRepository repository, UserRepository userRepository, ConfigRepository configRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.configRepository = configRepository;
    }

    @Override
    public Ponto registrarPonto(int usuarioId) {
        var inicio = LocalDate.now().atTime(LocalTime.MIN);
        var fim = LocalDate.now().atTime(LocalTime.MAX);
        Ponto ultimoPonto = repository.findByUsuarioIdAndTimestampBetweenOrderByTimestampDesc(usuarioId, inicio, fim).getFirst();
        TipoPonto ultimoTipoPonto = ultimoPonto.getTipoPonto();

        Usuario usuario = userRepository.getReferenceById(usuarioId);

        Configuracoes config = configRepository.findTopByOrderByTimestampDesc();

        var ponto = new Ponto(ultimoTipoPonto.alternar(), usuario, config);
        return repository.save(ponto);
    }

    @Override
    public TipoPonto getUltimoTipoUsuario(int usuarioId) {
        return null;
    }
}
