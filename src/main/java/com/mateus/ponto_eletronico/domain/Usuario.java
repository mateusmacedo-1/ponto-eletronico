package com.mateus.ponto_eletronico.domain;

import com.mateus.ponto_eletronico.dto.CreateUserRequest;
import com.mateus.ponto_eletronico.exceptions.business.BusinessException;
import jakarta.persistence.*;

import java.util.Arrays;

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
        String papeis = String.join(", ",
                Arrays.stream(Papel.values())
                        .map(Enum::name)
                        .toArray(String[]::new)
        );
        this.id = 0;
        this.name = userDto.name();
        this.email = userDto.email();
        try{
            this.papel = Papel.valueOf(userDto.papel());
        } catch (Exception e) {
            throw new BusinessException(String.format("O papel informado não está entre os permitidos: %s", papeis));
        }

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
