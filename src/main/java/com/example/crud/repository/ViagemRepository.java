package com.example.crud.repository;


import com.example.crud.model.ResourceNotFoundException;
import com.example.crud.model.StatusViagemEnum;
import com.example.crud.model.Viagem;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Repository
public class ViagemRepository {
    
    private List<Viagem> viagems = new ArrayList<Viagem>();

    public Viagem criar(Viagem viagem) {
        Long id = 1L;
        if(!viagems.isEmpty()) {
            id = viagems.stream().max(Comparator.comparing(Viagem::getId)).get().getId() + 1L;
        }
        viagem.setId(id);
        viagems.add(viagem);
        return viagem;
    }

    public List<Viagem> viagems() {
        return viagems;
    }

    public Viagem viagem(Long id) {
        for (Viagem viagem : viagems) {
            if(Objects.equals(viagem.getId(), id)) {
                return viagem;
            }
        }
        throw new ResourceNotFoundException("Viagem nao encontrada", "viagem.not.found");
    }

    public void atualizar(Viagem viagem, Long id) {
        Viagem viagemSalva = viagem(id);
        viagemSalva.setRota(viagem.getRota());
        viagemSalva.setMotorista(viagem.getMotorista());
        viagemSalva.setVeiculo(viagem.getVeiculo());
        viagemSalva.setIniciaEm(viagem.getIniciaEm());
        viagemSalva.setAtualizadoEm(LocalDateTime.now());
    }

    public void excluir(Long id) {
        viagems.removeIf(rota -> Objects.equals(rota.getId(), id));
    }

    public void atualizaStatus(StatusViagemEnum statusViagemEnum, Long id) {
        Viagem viagem = viagem(id);
        viagem.setStatus(statusViagemEnum);
        viagem.setAtualizadoEm(LocalDateTime.now());
    }
}

