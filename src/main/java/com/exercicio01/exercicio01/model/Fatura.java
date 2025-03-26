package com.exercicio01.exercicio01.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Número do cartão é obrigatório")
    @Pattern(regexp = "^\\d{16}$", message = "Deve conter exatamente 16 dígitos numéricos")
    private String numeroCartao;

    @NotBlank(message = "Nome do titular é obrigatório")
    @Size(min = 3, max = 100, message = "Deve ter entre 3 e 100 caracteres")
    private String nomeTitular;

    @NotNull(message = "Valor é obrigatório")
    @DecimalMin(value = "10.00", message = "Valor mínimo é R$ 10.00")
    @DecimalMax(value = "5000.00", message = "Valor máximo é R$ 5000.00")
    private Double valor;

    @NotNull(message = "Data de pagamento é obrigatória")
    @FutureOrPresent(message = "Data deve ser presente ou futura")
    private LocalDate dataPagamento;

    @NotBlank(message = "E-mail de contato é obrigatório")
    @Email(message = "Formato de e-mail inválido")
    private String emailContato;
}
