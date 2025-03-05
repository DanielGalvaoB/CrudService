package com.example.crud.model;

import java.time.LocalDateTime;

public class Viagem {
    private Long id;
    private Rota rota;
    private Veiculo veiculo;
    private Motorista motorista;
    final private LocalDateTime criadoEm = LocalDateTime.now();
    private LocalDateTime atualizadoEm = LocalDateTime.now();
    private LocalDateTime iniciaEm;
    private StatusViagemEnum status;

    public LocalDateTime getIniciaEm() {
        return iniciaEm;
    }

    public void setIniciaEm(LocalDateTime iniciaEm) {
        this.iniciaEm = iniciaEm;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(LocalDateTime atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }

    public StatusViagemEnum getStatus() {
        return status;
    }

    public void setStatus(StatusViagemEnum status) {
        this.status = status;
    }
}
