package com.sd.brigadeiria.repository;

import com.sd.brigadeiria.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
   Usuario findByEmail(String username);
}
