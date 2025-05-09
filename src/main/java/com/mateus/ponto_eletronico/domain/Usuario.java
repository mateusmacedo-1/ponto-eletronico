package com.mateus.ponto_eletronico.domain;

import com.mateus.ponto_eletronico.dto.CreateUserRequest;
import jakarta.persistence.*;

@Table(name="usuario")
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String email;
    private Papel papel;

    public Usuario() {
    }

    public Usuario(int id, String name, String email, Papel papel) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.papel = papel;
    }

    public Usuario(CreateUserRequest userDto) {
        this.id = 0;
        this.name = userDto.name();
        this.email = userDto.email();
        this.papel = userDto.papel();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

    public int getId() {
        return id;
    }
}
