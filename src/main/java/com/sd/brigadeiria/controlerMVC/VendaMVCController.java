package com.sd.brigadeiria.controlerMVC;

import java.util.List;

import com.sd.brigadeiria.model.Venda;
import com.sd.brigadeiria.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VendaMVCController {
    
    @Autowired
    private VendaRepository vendaRepository;

    @GetMapping("/vendaporpessoam")
    public List<Venda> listaVenda(){
        List<Venda> venda = vendaRepository.findAll();
        return venda;
    }
 
}
