package com.example.crud.model;

public class ResourceNotFoundException extends RuntimeException{
    private String code;
    public ResourceNotFoundException(String message, String code) {
        super(message);
        this.code = code;
    }
    public String getCode() {
        return code;
    }
}
