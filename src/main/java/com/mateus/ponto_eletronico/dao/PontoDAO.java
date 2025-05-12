package com.mateus.ponto_eletronico.dao;

import com.mateus.ponto_eletronico.domain.Ponto;
import com.mateus.ponto_eletronico.domain.TipoPonto;

public interface PontoDAO {
    Ponto registrarPonto(int usuarioId);
    TipoPonto getUltimoTipoUsuario(int usuarioId);
}
