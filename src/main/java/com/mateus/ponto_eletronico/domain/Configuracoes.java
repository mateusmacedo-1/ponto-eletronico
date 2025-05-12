package com.mateus.ponto_eletronico.domain;

import com.mateus.ponto_eletronico.dto.configs.CreateConfigRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Table(name="configuracoes")
@Entity
public class Configuracoes {
    @Id
    @GeneratedValue
    private int id;
    private LocalDateTime timestamp;
    private float jornadaDiariaHoras;
    private float qtdHoraExtraPermitida;
    private boolean ativa;

    public Configuracoes() {
    }

    public Configuracoes(int id, float jornadaDiariaHoras, float qtdHoraExtraPermitida, LocalDateTime timestamp, boolean ativa) {
        this.id = id;
        this.jornadaDiariaHoras = jornadaDiariaHoras;
        this.qtdHoraExtraPermitida = qtdHoraExtraPermitida;
        this.timestamp = timestamp;
        this.ativa = ativa;
    }

    public Configuracoes(CreateConfigRequest dto) {
        this.jornadaDiariaHoras = dto.jornadaDiariaHoras();
        this.qtdHoraExtraPermitida = dto.qtdHoraExtraPermitida();
        this.timestamp = LocalDateTime.now();
        this.ativa = true;
    }

    public float getJornadaDiariaHoras() {
        return jornadaDiariaHoras;
    }

    public float getQtdHoraExtraPermitida() {
        return qtdHoraExtraPermitida;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getId() {
        return id;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setId(int id) {
        this.id = id;
    }
}
