package com.sd.brigadeiria.mvc;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.sd.brigadeiria.model.Categoria;
import com.sd.brigadeiria.model.Cliente;
import com.sd.brigadeiria.model.Pedido;
import com.sd.brigadeiria.model.Produto;
import com.sd.brigadeiria.repository.CategoriaRepository;
import com.sd.brigadeiria.repository.ClienteRepository;
import com.sd.brigadeiria.repository.PedidoRepository;
import com.sd.brigadeiria.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/pedido")
public class PedidoMVCController {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("novo")
    public String novoFormPedido(Model model){
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);
        List<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "/pedido/pedidoform";
    }
    
    @GetMapping("/lista")
    public List<Pedido> listaVenda(){
        List<Pedido> venda = pedidoRepository.findAll();
        return venda;
    }

    @PostMapping("/salvar")
    public void salvar(Pedido pedido, Model model){
        
        pedidoRepository.save(pedido);
        model.addAttribute("lista", pedidoRepository.findAll());
        System.out.println("pedido salvo com sucesso");
    }


}
