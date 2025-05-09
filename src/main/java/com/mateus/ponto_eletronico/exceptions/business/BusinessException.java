package com.mateus.ponto_eletronico.exceptions.business;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
