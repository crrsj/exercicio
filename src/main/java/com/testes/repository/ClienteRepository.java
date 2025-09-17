package com.testes.repository;

import com.testes.dto.ClienteDTO;
import com.testes.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
 Optional<Cliente> findByTelefone(String telefone);
}
