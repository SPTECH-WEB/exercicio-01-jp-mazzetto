package com.example.fatura.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.fatura.model.fatura;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class faturaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void criarFaturaValida() throws Exception {
        fatura fatura = new fatura(
                null,
                "1234567812345678",
                "Maria Teste",
                100.00,
                LocalDate.now().plusDays(1),
                "maria@email.com"
        );

        mockMvc.perform(post("/faturas")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(fatura)))
                .andExpect(status().isOk());
    }
}
