package com.example.crud.service;

import java.util.List;

public interface CrudService<T, R> {
    T criar(T value);
    List<T> listar();
    T findaById(R id);
    void alterar(T value, R id);
    void excluir(R id);
}
