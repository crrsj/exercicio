package com.testes.controller;

import com.testes.entity.Produto;
import com.testes.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping("/{clienteId}")
    public ResponseEntity<Produto>salvarProduto(@PathVariable Long clienteId, @RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvarProduto(clienteId,produto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto>atualizarProdito(@PathVariable Long id,@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.atualizarProduto(id,produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>>buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listarProdutos());
    }
}
