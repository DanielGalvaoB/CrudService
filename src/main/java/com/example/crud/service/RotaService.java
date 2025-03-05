package com.example.crud.service;

import com.example.crud.model.Rota;
import com.example.crud.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotaService implements CrudService<Rota, Long> {
    @Autowired
    RotaRepository repository;

    @Override
    public Rota criar(Rota value) {
        return repository.criar(value);
    }

    @Override
    public List<Rota> listar() {
        return repository.rotas();
    }

    @Override
    public Rota findaById(Long id) {
        return repository.rota(id);
    }

    @Override
    public void alterar(Rota value, Long id) {
        repository.atualizar(value, id);
    }

    @Override
    public void excluir(Long id) {
        repository.excluir(id);
    }
}
