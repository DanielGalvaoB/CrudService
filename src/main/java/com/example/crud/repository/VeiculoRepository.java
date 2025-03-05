package com.example.crud.repository;

import com.example.crud.model.ResourceNotFoundException;
import com.example.crud.model.Veiculo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class VeiculoRepository {
    private List<Veiculo> veiculos = new ArrayList<>();

    public Veiculo criarVeiculo(Veiculo veiculo) {
        veiculos.forEach(v -> {
            if (Objects.equals(v.getPlaca(), veiculo.getPlaca())) {
                throw new RuntimeException("Veiculo já cadastrado");
            }
        });
        veiculos.add(veiculo);
        return veiculo;
    }

    public List<Veiculo> consultarVeiculos() {
        return veiculos;
    }

    public Veiculo consultarVeiculo(String placa) {
        for (Veiculo veiculo : veiculos) {
            if(Objects.equals(veiculo.getPlaca(), placa)) {
                return veiculo;
            }
        }
        throw new ResourceNotFoundException("Veiculo nao encontrado", "veiculo.not.found");
    }

    public void atualizarVeiculo(Veiculo veiculo, String placa) {
        Veiculo veiculoSalvo = consultarVeiculo(placa);
        veiculoSalvo.setPlaca(veiculo.getPlaca());
        veiculoSalvo.setCapacidade(veiculo.getCapacidade());
        veiculoSalvo.setModelo(veiculo.getModelo());
        veiculoSalvo.setDisponivel(veiculo.isDisponivel());
    }

    public void excluirVeiculo(String placa) {
        veiculos.removeIf(veiculo -> Objects.equals(veiculo.getPlaca(), placa));
    }
}
