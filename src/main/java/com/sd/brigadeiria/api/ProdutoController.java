package com.sd.brigadeiria.api;

import java.util.List;

import com.sd.brigadeiria.model.Categoria;
import com.sd.brigadeiria.model.Produto;
import com.sd.brigadeiria.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.matcher.StringMatcher.Mode;

@RestController
@RequestMapping("/apiproduto")
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping("/produtos")
    public List<Produto> listaProdutos(){
        List<Produto> lista = produtoRepository.findAll();
        return lista;
    }

    @GetMapping("/addSelectProdutoPorCategoria")
    public List<Produto> addSelectProdutoPorCategoria(@RequestParam long idCategoria, Mode model){
        Categoria categoria = new Categoria();
        categoria.setId(idCategoria);
        List<Produto> produtos = produtoRepository.findByCategoria(categoria);
        return produtos;
    }
}
