package com.mateus.ponto_eletronico.business;


import com.mateus.ponto_eletronico.dao.UserDAO;
import com.mateus.ponto_eletronico.domain.Papel;
import com.mateus.ponto_eletronico.domain.Usuario;
import com.mateus.ponto_eletronico.exceptions.business.BusinessException;
import com.mateus.ponto_eletronico.exceptions.business.ConflitoException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserBC {

    private final UserDAO userDAO;

    public UserBC(@Qualifier("userDAOJPA") UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public int createUser(Usuario usuario) {
        boolean isNomeValido = true;
        boolean isUsuarioJaCadastrado = userDAO.existsByEmail(usuario.getEmail());
        if (!isNomeValido) {
            throw new BusinessException("Erro ao criar usuário. Confira os dados e tente novamente.");
        } else if (isUsuarioJaCadastrado) {
            throw new ConflitoException("Usuário já cadastrado com e-mail fornecido: " + usuario.getEmail());
        } else {
            return userDAO.create(usuario);
        }
    }

    public List<Usuario> getAll() {
        return userDAO.getAll();
    }

    public Usuario getById(int id) {
        return userDAO.getById(id);
    }
}
