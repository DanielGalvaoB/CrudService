package com.example.crud.service;

import com.example.crud.model.Motorista;
import com.example.crud.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristaService implements CrudService<Motorista, String> {
    @Autowired
    private MotoristaRepository repository;

    @Override
    public Motorista criar(Motorista value) {
        validarMotorista(value);
        return repository.criar(value);
    }

    @Override
    public List<Motorista> listar() {
        return repository.motoristas();
    }

    @Override
    public Motorista findaById(String documento) {
        return repository.motorista(documento);
    }

    @Override
    public void alterar(Motorista value, String documento) {
        validarMotorista(value);
        repository.atualizar(value, documento);
    }

    @Override
    public void excluir(String documento) {
        repository.excluir(documento);
    }

    private void validarMotorista(Motorista motorista) {
        if(!motorista.isDocumentoValido())
            throw new RuntimeException("Documento invalido");
    }
}
