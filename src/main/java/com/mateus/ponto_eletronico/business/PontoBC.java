package com.mateus.ponto_eletronico.business;


import com.mateus.ponto_eletronico.dao.PontoDAO;
import com.mateus.ponto_eletronico.domain.Ponto;
import com.mateus.ponto_eletronico.domain.TipoPonto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PontoBC {

    private final PontoDAO dao;

    public PontoBC(@Qualifier("pontoDAOJPA") PontoDAO dao) {
        this.dao = dao;
    }

    public TipoPonto getTipoUltimaBatida() {
        return TipoPonto.ENTRADA;
    }

    public Ponto registrarPonto(int usuarioId) {
        return dao.registrarPonto(usuarioId);
    }
}
