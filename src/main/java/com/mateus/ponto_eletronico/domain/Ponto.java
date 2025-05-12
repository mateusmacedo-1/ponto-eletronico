package com.mateus.ponto_eletronico.domain;

import com.mateus.ponto_eletronico.dto.CreateConfigRequest;
import jakarta.persistence.*;

import java.util.Date;


@Table(name="ponto")
@Entity
public class Ponto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date timestamp;
    private TipoPonto tipoPonto;
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name="config_id")
    private Configuracoes configuracoes;

    public Ponto() {}

    public Ponto(int id, Date timestamp, TipoPonto tipoPonto, Usuario usuario, Configuracoes configuracoes) {
        this.id = id;
        this.timestamp = timestamp;
        this.tipoPonto = tipoPonto;
        this.usuario = usuario;
        this.configuracoes = configuracoes;
    }


    public int getId() {
        return id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public TipoPonto getTipoPonto() {
        return tipoPonto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Configuracoes getConfiguracoes() {
        return configuracoes;
    }
}
