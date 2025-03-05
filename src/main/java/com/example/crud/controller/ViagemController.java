package com.example.crud.controller;

import com.example.crud.model.StatusViagemEnum;
import com.example.crud.model.Viagem;
import com.example.crud.service.ViagemSrevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viagens")
public class ViagemController {
    @Autowired
    private ViagemSrevice viagemSrevice;

    @GetMapping
    public List<Viagem> getViagems() {
        return viagemSrevice.listar();
    }

    @GetMapping("/{id}")
    public Viagem getViagem(@PathVariable Long id) {
        return viagemSrevice.findaById(id);
    }


    @PostMapping
    public Viagem cadastrarViagem(@RequestBody Viagem viagem) {
        return viagemSrevice.criar(viagem);
    }

    @PutMapping("/{id}")
    public void atualizarViagem(@RequestBody Viagem viagem,@PathVariable Long id) {
        viagemSrevice.alterar(viagem, id);
    }


    @DeleteMapping("/{id}")
    public void removerViagem(@PathVariable Long id) {
        viagemSrevice.excluir(id);
    }

    @PatchMapping("/{id}/status")
    public void atualizarViagemStatus(@RequestHeader StatusViagemEnum status, @PathVariable Long id) {
        viagemSrevice.atualizaStatusViagem(status, id);
    }

}
