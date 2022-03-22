package com.sd.brigadeiria.mvc;

import java.util.List;
import java.util.Optional;

import com.sd.brigadeiria.model.Categoria;
import com.sd.brigadeiria.model.Produto;
import com.sd.brigadeiria.repository.CategoriaRepository;
import com.sd.brigadeiria.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/produto")
public class ProdutoMVCController {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/novo")
    public String form(Produto produto, Model model) {
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);
        return "/produto/produtoformtableless";
    }

    @PostMapping("/salvar")
    public String salvar(Produto produto, Model model){
        
        produtoRepository.save(produto);
        model.addAttribute("lista", produtoRepository.findAll());
        return "produto/produtos";
    }
    
    @GetMapping("/listar")
    public String listaProdutos(Model model){
        model.addAttribute("lista", produtoRepository.findAll()); 
        return "produto/produtos";
    }

    @GetMapping("/excluir")
    public String excluir(@RequestParam long id, Model model){
        produtoRepository.deleteById(id); 
        model.addAttribute("lista", produtoRepository.findAll());
        return "produto/produtos";
    }

    @GetMapping("/editar")
    public String mostrarEditForm(@RequestParam long id, Model model){
        
        try {
            List<Categoria> categorias = categoriaRepository.findAll();
            model.addAttribute("categorias", categorias);
            
            Optional<Produto> produto = listaProdutoPorId(id);
            model.addAttribute("produto", produto);
            return "/produto/produtoformtableless";
        } catch (ClienteNotFoundException e) {
            e.printStackTrace();
            return "erro";
        
        }
    }

    public void adicionaSelectCategoria(Model model){
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);
    }
    
    public Optional<Produto> listaProdutoPorId(Long id) throws ClienteNotFoundException {     
            Optional<Produto> produto = produtoRepository.findById(id);
            if(produto.isPresent()){
             return produto;
            }
            throw new ClienteNotFoundException("Cliente não pode ser encontrado");
        }
}
