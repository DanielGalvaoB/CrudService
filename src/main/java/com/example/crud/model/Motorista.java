package com.example.crud.model;

public class Motorista {
    private String nome;
    private String documento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public boolean isDocumentoValido() {
        return documento != null && !documento.isEmpty() && (documento.length() == 11 || documento.length() == 14);
    }
}
