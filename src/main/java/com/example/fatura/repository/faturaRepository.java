package com.example.fatura.repository;

import com.example.fatura.model.fatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface faturaRepository extends JpaRepository<fatura, Long> {
}
