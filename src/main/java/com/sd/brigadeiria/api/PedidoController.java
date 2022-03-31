package com.sd.brigadeiria.api;

import java.util.List;

import com.sd.brigadeiria.model.Pedido;
import com.sd.brigadeiria.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {
    
    @Autowired
    private PedidoRepository vendaRepository;

    @GetMapping("/vendaporpessoa")
    public List<Pedido> listaVenda(){
        List<Pedido> venda = vendaRepository.findAll();
        return venda;
    }
 
}
