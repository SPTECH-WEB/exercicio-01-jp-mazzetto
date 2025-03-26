package com.example.fatura.controller;

import com.example.fatura.model.fatura;
import com.example.fatura.repository.faturaRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faturas")
public class FaturaController {

    private final faturaRepository repository;

    public FaturaController(faturaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<fatura> listarTodas() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<fatura> cadastrar(@Valid @RequestBody fatura fatura) {
        return ResponseEntity.ok(repository.save(fatura));
    }
}
