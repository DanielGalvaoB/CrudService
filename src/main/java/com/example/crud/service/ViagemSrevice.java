package com.example.crud.service;

import com.example.crud.model.ParameterNotValidException;
import com.example.crud.model.StatusViagemEnum;
import com.example.crud.model.Viagem;
import com.example.crud.repository.MotoristaRepository;
import com.example.crud.repository.RotaRepository;
import com.example.crud.repository.VeiculoRepository;
import com.example.crud.repository.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ViagemSrevice implements CrudService<Viagem, Long> {
    @Autowired
    ViagemRepository repository;
    @Autowired
    RotaRepository rotaRepository;
    @Autowired
    VeiculoRepository veiculoRepository;
    @Autowired
    MotoristaRepository motoristaRepository;
    @Autowired
    private ViagemRepository viagemRepository;

    @Override
    public Viagem criar(Viagem viagem) {
        if(viagem.getIniciaEm() == null || !viagem.getIniciaEm().isAfter(LocalDateTime.now())) {
            throw new ParameterNotValidException("Data de inicio de viagem invalida.", "viagem.data.inicio.not.valid");
        }
        viagem.setRota(rotaRepository.rota(viagem.getRota().getId()));
        viagem.setVeiculo(veiculoRepository.consultarVeiculo(viagem.getVeiculo().getPlaca()));
        viagem.setMotorista(motoristaRepository.motorista(viagem.getMotorista().getDocumento()));
        return repository.criar(viagem);
    }

    @Override
    public List<Viagem> listar() {
        return repository.viagems().stream().map(v -> {
            if(v.getStatus() != StatusViagemEnum.FINALIZADA && v.getStatus() != StatusViagemEnum.CANCELADA) {
                v.setRota(rotaRepository.rota(v.getRota().getId()));
                v.setVeiculo(veiculoRepository.consultarVeiculo(v.getVeiculo().getPlaca()));
                v.setMotorista(motoristaRepository.motorista(v.getMotorista().getDocumento()));
            }
            return v;
        }).collect(Collectors.toList());
    }

    @Override
    public Viagem findaById(Long id) {
        return repository.viagem(id);
    }

    @Override
    public void alterar(Viagem value, Long id) {
        repository.viagem(id);
    }

    @Override
    public void excluir(Long id) {
        repository.viagem(id);
    }

    public void atualizaStatusViagem(StatusViagemEnum statusViagemEnum, Long id) {
        viagemRepository.atualizaStatus(statusViagemEnum, id);
    }

    public List<Viagem> pesquisaViagemPorCarro(String placa, List<StatusViagemEnum> status) {
        return viagemRepository.viagems().stream().filter(f ->
                f.getVeiculo().getPlaca().equals(placa) && (status == null || status.isEmpty() || status.contains(f.getStatus()))).collect(Collectors.toList());
    }
}
