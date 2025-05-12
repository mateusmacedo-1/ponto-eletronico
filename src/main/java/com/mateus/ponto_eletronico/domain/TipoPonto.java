package com.mateus.ponto_eletronico.domain;

public enum TipoPonto {
    ENTRADA, SAIDA;
    public TipoPonto alternar() {
        return this == ENTRADA ? SAIDA : ENTRADA;
    }
}
