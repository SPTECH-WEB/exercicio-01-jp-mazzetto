package com.example.fatura.model;

import jakarta.validation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class FaturaValidationTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void deveSerValidaComDadosCorretos() {
        fatura fatura = new fatura(
                null,
                "1234567812345678",
                "Carlos Silva",
                250.00,
                LocalDate.now(),
                "carlos@email.com"
        );

        Set<ConstraintViolation<fatura>> violations = validator.validate(fatura);
        assertTrue(violations.isEmpty());
    }

    @Test
    void deveDetectarCartaoInvalido() {
        fatura fatura = new fatura(
                null,
                "123", // inválido
                "Carlos Silva",
                250.00,
                LocalDate.now(),
                "carlos@email.com"
        );

        Set<ConstraintViolation<fatura>> violations = validator.validate(fatura);
        assertFalse(violations.isEmpty());

        boolean encontrouErro = violations.stream()
                .anyMatch(v -> v.getPropertyPath().toString().equals("numeroCartao"));
        assertTrue(encontrouErro);
    }

    @Test
    void deveDetectarEmailInvalido() {
        fatura fatura = new fatura(
                null,
                "1234567812345678",
                "Carlos Silva",
                250.00,
                LocalDate.now(),
                "email-invalido" // inválido
        );

        Set<ConstraintViolation<fatura>> violations = validator.validate(fatura);
        assertFalse(violations.isEmpty());

        boolean encontrouErro = violations.stream()
                .anyMatch(v -> v.getPropertyPath().toString().equals("emailContato"));
        assertTrue(encontrouErro);
    }
}
