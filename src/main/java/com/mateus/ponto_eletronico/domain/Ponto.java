package com.mateus.ponto_eletronico.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Table(name="ponto")
@Entity
public class Ponto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDateTime timestamp;
    private TipoPonto tipoPonto;
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name="config_id")
    private Configuracoes configuracoes;

    public Ponto() {}

    public Ponto(int id, LocalDateTime timestamp, TipoPonto tipoPonto, Usuario usuario, Configuracoes configuracoes) {
        this.id = id;
        this.timestamp = timestamp;
        this.tipoPonto = tipoPonto;
        this.usuario = usuario;
        this.configuracoes = configuracoes;
    }

    public Ponto(TipoPonto tipoPonto, Usuario usuario, Configuracoes configuracoes) {
        this.timestamp = LocalDateTime.now();
        this.tipoPonto = tipoPonto;
        this.usuario = usuario;
        this.configuracoes = configuracoes;
    }

    public Ponto(TipoPonto tipoPonto, Usuario usuario) {
        this.tipoPonto = tipoPonto;
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getTimestamp() {
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

    @Override
    public String toString() {
        return "Ponto{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", tipoPonto=" + tipoPonto +
                ", usuario=" + usuario +
                ", configuracoes=" + configuracoes +
                '}';
    }
}
