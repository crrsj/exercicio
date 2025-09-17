package com.testes.erros;

public class ProdutoNaoEncontrado extends RuntimeException {
    public ProdutoNaoEncontrado(String mensagem) {
        super(mensagem);
    }

    public ProdutoNaoEncontrado(){
        super("Produto não encontrado !");
    }
}
