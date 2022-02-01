package com.sd.brigadeiria.controller;

import java.util.List;

import com.sd.brigadeiria.model.Produto;
import com.sd.brigadeiria.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdutoMVCController {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produtosm")
    public List<Produto> listaProdutos(){
        List<Produto> lista = produtoRepository.findAll();
        return lista;
    }
}
