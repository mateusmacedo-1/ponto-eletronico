package com.mateus.ponto_eletronico.domain;

import com.mateus.ponto_eletronico.dto.CreateConfigRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Table(name="configuracoes")
@Entity
public class Configuracoes {
    @Id
    @GeneratedValue
    private int id;
    private Date timestamp;
    private float jornadaDiariaHoras;
    private float qtdHoraExtraPermitida;
    private boolean ativa;

    public Configuracoes() {
    }

    public Configuracoes(int id, float jornadaDiariaHoras, float qtdHoraExtraPermitida, Date timestamp, boolean ativa) {
        this.id = id;
        this.jornadaDiariaHoras = jornadaDiariaHoras;
        this.qtdHoraExtraPermitida = qtdHoraExtraPermitida;
        this.timestamp = timestamp;
        this.ativa = ativa;
    }

    public Configuracoes(CreateConfigRequest dto) {
        this.jornadaDiariaHoras = dto.jornadaDiariaHoras();
        this.qtdHoraExtraPermitida = dto.qtdHoraExtraPermitida();
        this.timestamp = new Date();
        this.ativa = true;
    }

    public float getJornadaDiariaHoras() {
        return jornadaDiariaHoras;
    }

    public float getQtdHoraExtraPermitida() {
        return qtdHoraExtraPermitida;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public int getId() {
        return id;
    }

    public boolean isAtiva() {
        return ativa;
    }
}
