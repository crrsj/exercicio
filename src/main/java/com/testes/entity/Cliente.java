package com.testes.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.engine.internal.Cascade;

import java.util.List;

import static org.hibernate.engine.internal.Cascade.cascade;

@Entity
@Data
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Produto>produtos;

}
