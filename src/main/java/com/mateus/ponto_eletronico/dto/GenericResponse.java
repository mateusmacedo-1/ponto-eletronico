package com.mateus.ponto_eletronico.dto;

import java.util.Scanner;

public class GenericResponse {
    private String message;

    public GenericResponse() {
        this.message  = """
                Requisição processada com sucesso.
            """;
    }

    public GenericResponse(String message){
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
