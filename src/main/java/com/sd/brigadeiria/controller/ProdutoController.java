package com.sd.brigadeiria.controller;

import java.util.List;

import com.sd.brigadeiria.model.Produto;
import com.sd.brigadeiria.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public List<Produto> listaProdutos(){
        List<Produto> lista = produtoRepository.findAll();
        return lista;
    }
}
