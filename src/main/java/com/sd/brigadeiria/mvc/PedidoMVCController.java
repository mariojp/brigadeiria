package com.sd.brigadeiria.mvc;

import java.util.List;

import com.sd.brigadeiria.model.Pedido;
import com.sd.brigadeiria.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedido")
public class PedidoMVCController {
    
    @Autowired
    private PedidoRepository vendaRepository;

    @GetMapping("novo")
    public String novoFormPedido(){
        return "/pedido/pedidoform";
    }
    
    @GetMapping("/lista")
    public List<Pedido> listaVenda(){
        List<Pedido> venda = vendaRepository.findAll();
        return venda;
    }
 
}
