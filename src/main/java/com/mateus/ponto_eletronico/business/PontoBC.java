package com.mateus.ponto_eletronico.business;


import com.mateus.ponto_eletronico.dao.ConfigDAO;
import com.mateus.ponto_eletronico.dao.PontoDAO;
import com.mateus.ponto_eletronico.dao.UserDAO;
import com.mateus.ponto_eletronico.domain.Configuracoes;
import com.mateus.ponto_eletronico.domain.Ponto;
import com.mateus.ponto_eletronico.domain.TipoPonto;
import com.mateus.ponto_eletronico.domain.Usuario;
import com.mateus.ponto_eletronico.exceptions.business.BusinessException;
import com.mateus.ponto_eletronico.exceptions.data.NotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PontoBC {

    private final PontoDAO dao;
    private final UserDAO userDAO;
    private final ConfigDAO configDAO;

    public PontoBC(@Qualifier("pontoDAOJPA")PontoDAO dao,
                   @Qualifier("userDAOJPA")UserDAO userDAO,
                   @Qualifier("configDAOJPA")ConfigDAO configDAO) {
        this.dao = dao;
        this.userDAO = userDAO;
        this.configDAO = configDAO;
    }

    public Ponto registrarPonto(int usuarioId) {
        try {
            // verifica se usuário existe antes. se mandar direto usuarioId a consulta de ultipoTipoPonto vem vazia
            // mas não é possível verificar se é pq o usuário não existe.
            Usuario usuario = userDAO.getById(usuarioId);
            Optional<Ponto> ultimoPontoOpt = dao.getUltimoPontoUsuario(usuario.getId());
            // REGRA 2.c O tipo registrado precisa ser o oposto do último ponto registrado no dia
            TipoPonto ultimoTipoPonto = ultimoPontoOpt.isEmpty() ? TipoPonto.ENTRADA : ultimoPontoOpt.get().getTipoPonto().alternar();
            Configuracoes config = configDAO.getLast();
            return dao.registrarPonto(usuario, ultimoTipoPonto, config);
        } catch (NotFoundException e) {
            throw new BusinessException(e.getMessage());
        }


    }
}
