package com.sd.brigadeiria.mvc;

import java.util.List;

import com.sd.brigadeiria.model.Venda;
import com.sd.brigadeiria.repository.VendaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pedido")
public class VendaMVCController {
    
    @Autowired
    private VendaRepository vendaRepository;

    @GetMapping("novo")
    public String novoFormPedido(){
        return "/pedido/pedidoform";
    }
    
    @GetMapping("/lista")
    public List<Venda> listaVenda(){
        List<Venda> venda = vendaRepository.findAll();
        return venda;
    }
 
}
