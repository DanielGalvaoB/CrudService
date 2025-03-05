package com.example.crud.repository;

import com.example.crud.model.Motorista;
import com.example.crud.model.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class MotoristaRepository {
    private List<Motorista> motoristas = new ArrayList<>();

    public Motorista criar(Motorista motorista) {
        motoristas.forEach(m -> {
            if (Objects.equals(m.getDocumento(), motorista.getDocumento())) {
                throw new RuntimeException("Motorista já cadastrado");
            }
        });
        motoristas.add(motorista);
        return motorista;
    }

    public List<Motorista> motoristas() {
        return motoristas;
    }

    public Motorista motorista(String documento) {
        for (Motorista motorista : motoristas) {
            if(Objects.equals(motorista.getDocumento(), documento)) {
                return motorista;
            }
        }
        throw new ResourceNotFoundException("Motorista nao encontrado", "motorista.not.found");
    }

    public void atualizar(Motorista motorista, String documento) {
        Motorista rotaSalva = motorista(documento);
        rotaSalva.setNome(motorista.getNome());
    }

    public void excluir(String documento) {
        motoristas.removeIf(rota -> Objects.equals(rota.getDocumento(), documento));
    }
}
