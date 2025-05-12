package com.mateus.ponto_eletronico.dto;

import com.mateus.ponto_eletronico.domain.Papel;

public record CreateUserRequest(String name, String email, String papel) {
}
