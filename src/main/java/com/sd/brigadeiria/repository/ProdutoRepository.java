package com.sd.brigadeiria.repository;

import java.util.List;

import com.sd.brigadeiria.model.Categoria;
import com.sd.brigadeiria.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

    List<Produto> findByCategoria(Categoria categoria);
    List<Produto> findByNome(String produto);
    Produto findByNomeAndTamanho(String nome, String tamanho);
    
    
   

}
