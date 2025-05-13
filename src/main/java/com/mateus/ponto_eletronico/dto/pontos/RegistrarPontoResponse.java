package com.mateus.ponto_eletronico.dto.pontos;

import com.mateus.ponto_eletronico.domain.Ponto;
import com.mateus.ponto_eletronico.dto.GenericResponse;

public class RegistrarPontoResponse extends GenericResponse {
    private Ponto ponto;
    public static final String CREATE_MESSAGE_SUCESS = "Ponto registrado com sucesso.";
    public static final String CREATE_MESSAGE_ERROR = "Erro ao registrar ponto: %s";

    public RegistrarPontoResponse(Ponto ponto) {
        super(CREATE_MESSAGE_SUCESS);
        this.ponto = ponto;
    }

    public RegistrarPontoResponse(String error) {
        super(String.format(CREATE_MESSAGE_ERROR, error));
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
