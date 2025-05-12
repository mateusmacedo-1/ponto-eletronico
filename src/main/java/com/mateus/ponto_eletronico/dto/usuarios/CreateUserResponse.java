package com.mateus.ponto_eletronico.dto.usuarios;


import com.mateus.ponto_eletronico.dto.GenericResponse;

public class CreateUserResponse extends GenericResponse {
    private final int userId;
    private static final String CREATE_USER_MESSAGE_SUCESS = "Usuário criado com sucesso.";
    private static final String CREATE_USER_MESSAGE_ERROR = "Erro ao criar o usuário.";

    public CreateUserResponse(int userId) {
        super(userId != 0 ? CREATE_USER_MESSAGE_SUCESS : CREATE_USER_MESSAGE_ERROR);
        this.userId = userId;
    }

    public CreateUserResponse(int userId, String message) {
        super(message);
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "CreateUserResponse{" +
                "userId=" + userId +
                "message=" + this.getMessage() +
                '}';
    }
}
