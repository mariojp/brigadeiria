package com.sd.brigadeiria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.sd.brigadeiria.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    List<Cliente> findByTipo(String tipo);
    List<Cliente> findByCpf(String cpf);
}
