package com.mateus.ponto_eletronico.dao;

import com.mateus.ponto_eletronico.domain.Usuario;
import com.mateus.ponto_eletronico.exceptions.data.NotFoundException;

import java.util.List;

public class UserDAOJPA implements UserDAO {

    private final UserRepository repository;

    public UserDAOJPA(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario getById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }

    @Override
    public List<Usuario> getAll() {
        return List.of();
    }

    @Override
    public int create(Usuario usuario) {
        var created = repository.save(usuario);
        return created.getId();
    }
}
