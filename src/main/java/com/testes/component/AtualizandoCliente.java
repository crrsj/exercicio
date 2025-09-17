package com.testes.component;

import com.testes.dto.ClienteDTO;
import com.testes.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class AtualizandoCliente {

    public void atualizar( Cliente cliente,ClienteDTO dto ){
        if(dto.getNome() != null && !dto.getNome().isEmpty()){
            cliente.setNome(dto.getNome());
        }
        if(dto.getTelefone() != null && !dto.getTelefone().isEmpty()){
            cliente.setTelefone(dto.getTelefone());
        }
    }
}
