package com.testes.erros;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
@Data
@AllArgsConstructor
public class MensagendDeErros {
  private  HttpStatus status;
   private String mensagem;

}
