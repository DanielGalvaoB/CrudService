package com.example.crud.repository;

import com.example.crud.model.ResourceNotFoundException;
import com.example.crud.model.Rota;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Repository
public class RotaRepository {
    private List<Rota> rotas = new ArrayList<>();

    public Rota criar(Rota rota) {
        Long id = 1L;
        if(!rotas.isEmpty()) {
           id = rotas.stream().max(Comparator.comparing(Rota::getId)).get().getId() + 1L;
        }
        rota.setId(id);
        rotas.add(rota);
        return rota;
    }

    public List<Rota> rotas() {
        return rotas;
    }

    public Rota rota(Long id) {
        for (Rota rota : rotas) {
            if(Objects.equals(rota.getId(), id)) {
                return rota;
            }
        }
        throw new ResourceNotFoundException("Rota nao encontrada", "rota.not.found");
    }

    public void atualizar(Rota veiculo, Long id) {
        Rota rotaSalva = rota(id);
        rotaSalva.setDestino(veiculo.getDestino());
        rotaSalva.setOrigem(veiculo.getOrigem());
    }

    public void excluir(Long id) {
        rotas.removeIf(rota -> Objects.equals(rota.getId(), id));
    }
}
