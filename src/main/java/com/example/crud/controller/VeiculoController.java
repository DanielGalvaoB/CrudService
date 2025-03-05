package com.example.crud.controller;

import com.example.crud.model.Veiculo;
import com.example.crud.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<Veiculo> VeiculoController() {
        return veiculoService.listar();
    }

    @PostMapping
    public Veiculo cadastrarVeiculo(@RequestBody Veiculo veiculo) {
        return veiculoService.criar(veiculo);
    }

    @PutMapping("/{placa}")
    public void atualizarVeiculo(@RequestBody Veiculo veiculo, @PathVariable String placa) {
        veiculoService.alterar(veiculo, placa);
    }

    @GetMapping("/{placa}")
    public Veiculo buscarVeiculo(@PathVariable String placa) {
        return veiculoService.findaById(placa);
    }

    @DeleteMapping("/{placa}")
    public void deletarVeiculo(@PathVariable String placa) {
        veiculoService.excluir(placa);
    }
}
