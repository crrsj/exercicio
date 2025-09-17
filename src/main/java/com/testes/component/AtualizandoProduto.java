package com.testes.component;

import com.testes.entity.Produto;
import org.springframework.stereotype.Component;

@Component
public class AtualizandoProduto {
    public void produtoAtualizado(Produto destino, Produto origem){
        if(origem.getMarca() != null && !origem.getMarca().isEmpty()){
            destino.setMarca(origem.getMarca());
        }

        if(origem.getModelo() != null && !origem.getModelo().isEmpty()){
            destino.setModelo(origem.getModelo());
        }
    }
}
