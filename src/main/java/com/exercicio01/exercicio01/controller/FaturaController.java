package com.exercicio01.exercicio01.controller;

import com.exercicio01.exercicio01.model.Fatura;
import com.exercicio01.exercicio01.service.FaturaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/faturas")
public class FaturaController {
    private final FaturaService faturaService;

    public FaturaController(FaturaService faturaService) {
        this.faturaService = faturaService;
    }

    @PostMapping
    public ResponseEntity<Fatura> criarFatura(@Valid @RequestBody Fatura fatura) {
        Fatura novaFatura = faturaService.salvarFatura(fatura);
        return new ResponseEntity<>(novaFatura, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Fatura>> listarFaturas() {
        List<Fatura> faturas = faturaService.listarFaturas();
        return ResponseEntity.ok(faturas);
    }
}
