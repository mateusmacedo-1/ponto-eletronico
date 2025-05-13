package com.mateus.ponto_eletronico.dao;

import com.mateus.ponto_eletronico.domain.Configuracoes;
import com.mateus.ponto_eletronico.domain.Ponto;
import com.mateus.ponto_eletronico.domain.TipoPonto;
import com.mateus.ponto_eletronico.domain.Usuario;

import java.util.Optional;

public interface PontoDAO {
    Ponto registrarPonto(Usuario usuario, TipoPonto tipoPonto, Configuracoes config);
    Optional<Ponto> getUltimoPontoUsuario(int usuarioId);
}
