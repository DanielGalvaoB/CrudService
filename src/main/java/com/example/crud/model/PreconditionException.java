package com.example.crud.model;

public class PreconditionException extends RuntimeException{
    private String code;
    public PreconditionException(String message, String code) {
        super(message);
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}
