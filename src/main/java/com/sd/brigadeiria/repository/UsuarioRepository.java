package com.sd.brigadeiria.repository;

import com.sd.brigadeiria.model.Cliente;
import com.sd.brigadeiria.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findUsuarioByLogin(String login);

}
