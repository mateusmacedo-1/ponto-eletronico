package com.mateus.ponto_eletronico.business;

import com.mateus.ponto_eletronico.dao.ConfigDAO;
import com.mateus.ponto_eletronico.domain.Configuracoes;
import com.mateus.ponto_eletronico.exceptions.business.BusinessException;
import com.mateus.ponto_eletronico.exceptions.business.ConflitoException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigBC {

    public static final int HORA_EXTRA_MAXIMA_CLT = 2;
    public static final int JORNADA_MAXIMA_CLT = 8;

    public ConfigDAO configDAO;

    public ConfigBC(@Qualifier("configDAOJPA") ConfigDAO configDAO) {
        this.configDAO = configDAO;
    }

    public Configuracoes getCurrent(){
        return this.configDAO.getLast();
    }

    public int create(Configuracoes config){
        boolean isJornadaValida = isJornadaValida(config);
        boolean isTaxaValida = isTaxaValida(config);
        if (!isJornadaValida) {
            throw new BusinessException(String.format("Jornada inválida. Valor deve estar entre 4 e %s HORAS", JORNADA_MAXIMA_CLT));
        } else if(!isTaxaValida){
            throw new BusinessException(String.format("Taxa de hora extra inválida. Valor deve estar entre 0 e %s HORAS", HORA_EXTRA_MAXIMA_CLT));
        } else {
            return configDAO.create(config);
        }
    }

    private static boolean isTaxaValida(Configuracoes config) {
        return config.getQtdHoraExtraPermitida() <= HORA_EXTRA_MAXIMA_CLT && config.getQtdHoraExtraPermitida() > 0;
    }

    private static boolean isJornadaValida(Configuracoes config) {
        return config.getJornadaDiariaHoras() <= JORNADA_MAXIMA_CLT && config.getJornadaDiariaHoras() > 4;
    }

    public List<Configuracoes> getAll() {
        return configDAO.getAll();
    }
}
