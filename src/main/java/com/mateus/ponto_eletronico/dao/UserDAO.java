package com.mateus.ponto_eletronico.dao;

import com.mateus.ponto_eletronico.domain.Usuario;

import java.util.List;


public interface UserDAO {
    Usuario getById(int id);
    List<Usuario> getAll();
    int create(Usuario usuario);
    boolean existsByEmail(String email);
}
