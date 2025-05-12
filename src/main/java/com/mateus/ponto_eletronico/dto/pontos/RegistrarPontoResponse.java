package com.mateus.ponto_eletronico.dto.pontos;

import com.mateus.ponto_eletronico.domain.Ponto;
import com.mateus.ponto_eletronico.dto.GenericResponse;

public class RegistrarPontoResponse extends GenericResponse {
    private Ponto ponto;
    private static final String CREATE_MESSAGE_SUCESS = "Ponto registrado com sucesso.";
    private static final String CREATE_MESSAGE_ERROR = "Erro ao registrar ponto.";

    public RegistrarPontoResponse(Ponto ponto) {
        super(CREATE_MESSAGE_SUCESS);
        this.ponto = ponto;
    }

    public RegistrarPontoResponse() {
        super(CREATE_MESSAGE_ERROR);
    }

    public Ponto getPonto() {
        return ponto;
    }

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }

    @Override
    public String toString() {
        return "RegistrarPontoResponse{" +
                "ponto=" + this.ponto +
                "message=" + this.getMessage() +
                '}';
    }
}
