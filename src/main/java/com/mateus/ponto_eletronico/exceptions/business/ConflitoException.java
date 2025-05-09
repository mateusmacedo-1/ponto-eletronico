package com.mateus.ponto_eletronico.exceptions.business;

public class ConflitoException extends RuntimeException {
    public ConflitoException(String message) {
        super(message);
    }
}
