package com.alura.foro.api.infra.exception;

public class UnauthorizedAccessException extends RuntimeException{

    public UnauthorizedAccessException(String s) {
        super(s);
    }
}
