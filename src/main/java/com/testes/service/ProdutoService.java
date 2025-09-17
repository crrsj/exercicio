package com.testes.service;

import com.testes.component.AtualizandoProduto;
import com.testes.entity.Produto;
import com.testes.erros.ClienteNaoEncontrado;
import com.testes.erros.ProdutoNaoEncontrado;
import com.testes.repository.ClienteRepository;
import com.testes.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;
    private final AtualizandoProduto atualizandoProduto;

    public Produto salvarProduto(long clienteId,Produto produto){
        var cliente = clienteRepository.findById(clienteId).orElseThrow(()->new ClienteNaoEncontrado("Cliente não encontrado !"));
          produto.setCliente(cliente);
        return produtoRepository.save(produto);
    }

    @Transactional
    public Produto atualizarProduto(Long id,Produto produto){
        var atualizar = produtoRepository.findById(id).orElseThrow(()->new ProdutoNaoEncontrado("produto não encontrado !"));
        atualizandoProduto.produtoAtualizado(atualizar,produto);
        return produtoRepository.save(atualizar);
    }

    public List<Produto>listarProdutos(){
        return produtoRepository.findAll();
    }
}
