package com.testes.component;

import com.testes.dto.ClienteDTO;
import com.testes.entity.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ConversorDto {

    public Cliente dtoParaEntidade(ClienteDTO clienteDTO){
        var cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
        cliente.setTelefone(clienteDTO.getTelefone());
        return cliente;
    }

    public ClienteDTO entidadeParaDto(Cliente cliente){
        var clienteDto = new ClienteDTO();
        clienteDto.setId(cliente.getId());
        clienteDto.setNome(cliente.getNome());
        clienteDto.setTelefone(cliente.getTelefone());
        return clienteDto;
    }
}
