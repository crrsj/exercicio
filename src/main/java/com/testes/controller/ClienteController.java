package com.testes.controller;

import com.testes.dto.ClienteDTO;
import com.testes.entity.Cliente;
import com.testes.service.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteDTO>salvarCliente(@RequestBody @Valid ClienteDTO clienteDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvarCliente(clienteDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO>atualizarCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.atualizarCliente(id,clienteDTO));

    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO>buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>>buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>excluirClientes(@PathVariable Long id){
        clienteService.excluirCliente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/telefone")
    public ResponseEntity<ClienteDTO>buscarPorTelefone(@RequestParam String telefone){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.buscarPorTelefone(telefone));
    }
}
