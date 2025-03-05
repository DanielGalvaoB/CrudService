package com.example.crud.controller;

import com.example.crud.model.Rota;
import com.example.crud.service.RotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rotas")
public class RotaController {
    @Autowired
    RotaService service;

    @GetMapping
    public List<Rota> rotas() {
        return service.listar();
    }

    @GetMapping("{id}")
    public Rota rota(@PathVariable("id") Long id) {
        return service.findaById(id);
    }

    @PostMapping
    public Rota save(@RequestBody Rota rota) {
        return service.criar(rota);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Rota rota) {
        service.alterar(rota, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.excluir(id);
    }
}
