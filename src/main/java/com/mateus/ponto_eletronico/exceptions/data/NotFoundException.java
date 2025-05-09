package com.mateus.ponto_eletronico.exceptions.data;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
