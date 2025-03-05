package com.example.crud.controller;

import com.example.crud.model.Motorista;
import com.example.crud.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {
    @Autowired
    private MotoristaService motoristaService;

    @GetMapping
    public List<Motorista> listar() {
        return motoristaService.listar();
    }

    @GetMapping("/{documento}")
    public Motorista motorista(@PathVariable String documento) {
        return motoristaService.findaById(documento);
    }

    @PostMapping
    public Motorista salvar(@RequestBody Motorista motorista) {
        return motoristaService.criar(motorista);
    }

    @PutMapping("/{documento}")
    public void atualizar(@PathVariable String documento, @RequestBody Motorista motorista) {
        motoristaService.alterar(motorista, documento);
    }

    @DeleteMapping("/{documento}")
    public void remover(@PathVariable String documento) {
        motoristaService.excluir(documento);
    }
}
