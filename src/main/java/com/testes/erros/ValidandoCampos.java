package com.testes.erros;

import lombok.Data;
import org.springframework.validation.FieldError;

@Data
public class ValidandoCampos {

    private String campo;
    private String mensagem;

    public ValidandoCampos(FieldError erros){
        this.campo = erros.getField();
        this.mensagem = erros.getDefaultMessage();
    }
}
