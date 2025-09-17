package com.testes.erros;

public class ClienteNaoEncontrado extends RuntimeException {
    public ClienteNaoEncontrado(String mensagem) {
        super(mensagem);
    }
    public ClienteNaoEncontrado() {
        super("Cliente não encontrado !");
    }
}
