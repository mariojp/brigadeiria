package com.sd.brigadeiria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import com.sd.brigadeiria.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
    List<Cliente> findByTipo(String tipo);
    Optional<Cliente> findByCpf(String cpf);
    Optional<Cliente> findById(Long id);
    List<Cliente> findAllByCpf(String cpf);
    List<Cliente> findAllByNome(String nome);
}
