package com.alura.foro.api.infra.exception;

public class DuplicateResourceException extends RuntimeException{

    public DuplicateResourceException (String s) {
        super(s);
    }
}
