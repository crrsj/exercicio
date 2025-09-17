package com.testes.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteDTO {
    private Long id;
    @NotBlank(message = "Não pode estar em branco !")
    private String nome;
    @NotBlank(message = "Não pode estar em branco !")
    private String telefone;
}
