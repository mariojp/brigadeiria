package com.sd.brigadeiria.api;

import java.util.List;

import com.sd.brigadeiria.model.Venda;
import com.sd.brigadeiria.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendaController {
    
    @Autowired
    private VendaRepository vendaRepository;

    @GetMapping("/vendaporpessoa")
    public List<Venda> listaVenda(){
        List<Venda> venda = vendaRepository.findAll();
        return venda;
    }
 
}
