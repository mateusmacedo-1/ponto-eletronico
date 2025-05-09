package com.mateus.ponto_eletronico.domain;

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
    private float taxaHorasExtrasPermitidas;
    private boolean ativa;

    public Configuracoes() {
    }

    public Configuracoes(int id, float jornadaDiariaHoras, float taxaHorasExtrasPermitidas, Date timestamp, boolean ativa) {
        this.id = id;
        this.jornadaDiariaHoras = jornadaDiariaHoras;
        this.taxaHorasExtrasPermitidas = taxaHorasExtrasPermitidas;
        this.timestamp = timestamp;
        this.ativa = ativa;
    }

    public Configuracoes(float jornadaDiariaHoras, float taxaHorasExtrasPermitidas, int id) {
        this.jornadaDiariaHoras = jornadaDiariaHoras;
        this.taxaHorasExtrasPermitidas = taxaHorasExtrasPermitidas;
        this.id = id;
        this.timestamp = new Date();
        this.ativa = true;
    }

    public float getJornadaDiariaHoras() {
        return jornadaDiariaHoras;
    }

    public float getTaxaHorasExtrasPermitidas() {
        return taxaHorasExtrasPermitidas;
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
