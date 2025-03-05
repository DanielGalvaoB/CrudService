package com.example.crud.service;

import com.example.crud.model.PreconditionException;
import com.example.crud.model.StatusViagemEnum;
import com.example.crud.repository.VeiculoRepository;
import com.example.crud.model.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService implements CrudService<Veiculo, String> {
    @Autowired
    private VeiculoRepository repository;
    @Autowired
    private ViagemSrevice viagemSrevice;

    @Override
    public Veiculo criar(Veiculo veiculo) {
        return repository.criarVeiculo(veiculo);
    }

    @Override
    public List<Veiculo> listar() {
        return repository.consultarVeiculos();
    }

    @Override
    public Veiculo findaById(String placa) {
        return repository.consultarVeiculo(placa);
    }

    @Override
    public void alterar(Veiculo veiculo, String placa) {
        repository.atualizarVeiculo(veiculo, placa);
    }

    @Override
    public void excluir(String placa) {
        if(!viagemSrevice.pesquisaViagemPorCarro(placa, List.of(StatusViagemEnum.EM_ANDAMENTO, StatusViagemEnum.RESERVADA)).isEmpty()) {
            throw new PreconditionException("Não podemos deletar carros com viagems agendadas, ou em andamento.", "carro.em.viagem.error");
        }
        repository.excluirVeiculo(placa);
    }
}
