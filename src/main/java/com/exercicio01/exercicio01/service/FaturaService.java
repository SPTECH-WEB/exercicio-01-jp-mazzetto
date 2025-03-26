package com.exercicio01.exercicio01.service;

import com.exercicio01.exercicio01.model.Fatura;
import com.exercicio01.exercicio01.repository.FaturaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FaturaService {
    private final FaturaRepository faturaRepository;

    public FaturaService(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    public Fatura salvarFatura(Fatura fatura) {
        return faturaRepository.save(fatura);
    }

    public List<Fatura> listarFaturas() {
        return faturaRepository.findAll();
    }
}
