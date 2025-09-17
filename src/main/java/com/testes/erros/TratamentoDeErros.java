package com.testes.erros;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TratamentoDeErros {

    @ExceptionHandler(ClienteNaoEncontrado.class)
    public ResponseEntity<MensagendDeErros>idNaoEncontrado(){
       var msg = new MensagendDeErros(HttpStatus.NOT_FOUND,"Cliente não encontrado !");
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?>validarCampos(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros.stream().map(ValidandoCampos::new).toList());
    }
}
