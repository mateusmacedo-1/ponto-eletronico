package com.mateus.ponto_eletronico.dao;

import com.mateus.ponto_eletronico.domain.Usuario;
import com.mateus.ponto_eletronico.exceptions.data.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        return repository.findAll();
    }

    @Override
    public int create(Usuario usuario) {
        var created = repository.save(usuario);
        return created.getId();
    }

    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }
}
