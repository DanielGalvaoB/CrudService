package com.example.crud.model;

public class ParameterNotValidException extends RuntimeException{
    private String code;
    public ParameterNotValidException(String message, String code) {
        super(message);
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}
