package com.testes.service;

import com.testes.component.AtualizandoCliente;
import com.testes.component.ConversorDto;
import com.testes.dto.ClienteDTO;
import com.testes.entity.Cliente;
import com.testes.erros.ClienteNaoEncontrado;
import com.testes.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final AtualizandoCliente atualizandoCliente;
    private final ConversorDto conversorDto;

    public ClienteDTO salvarCliente(ClienteDTO clienteDTO){
        var cliente = conversorDto.dtoParaEntidade(clienteDTO);
        var clienteSalvo = clienteRepository.save(cliente);
        return conversorDto.entidadeParaDto(clienteSalvo);
    }

    @Transactional
    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO){
        var atualize = clienteRepository.findById(id).orElseThrow();
        atualizandoCliente.atualizar(atualize,clienteDTO);
     /*  var atualizecliente = clienteRepository.save(atualize); O MÉTODO SALVA AUTOMATICAMENTE */
        return conversorDto.entidadeParaDto(atualize);
    }

    public ClienteDTO buscarPorId(Long id){
        var buscar =  clienteRepository.findById(id).orElseThrow(()-> new ClienteNaoEncontrado("Cliente não encontrado !"));
        return conversorDto.entidadeParaDto(buscar);
    }

    public List<ClienteDTO>buscarTodos(){
        return clienteRepository.findAll().stream().map(conversorDto::entidadeParaDto).toList();
    }

    public void excluirCliente(Long id){
        if (clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
        }else{
            throw new ClienteNaoEncontrado("Cliente não encontrado !");
        }

    }

    public ClienteDTO buscarPorTelefone(String telefone){
        var buscar = clienteRepository.findByTelefone(telefone).orElseThrow(() -> new ClienteNaoEncontrado("Cliente não encontrado !"));
        return conversorDto.entidadeParaDto(buscar);
    }
}
