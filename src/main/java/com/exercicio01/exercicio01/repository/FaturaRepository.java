package com.exercicio01.exercicio01.repository;

import com.exercicio01.exercicio01.model.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FaturaRepository extends JpaRepository<Fatura, Long> {
}
