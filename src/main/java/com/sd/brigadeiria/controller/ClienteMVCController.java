package com.sd.brigadeiria.controller;


import com.sd.brigadeiria.model.Cliente;
import com.sd.brigadeiria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ClienteMVCController {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @GetMapping("/clientesm")
    public String listaClientes(Model model){
        model.addAttribute("lista", clienteRepository.findAll());
        return "clientes";
    }

    @PostMapping("/clientem/salvar")
    public String salvar(Cliente cliente){
        clienteRepository.save(cliente);
        return "clienteform";
    }
    

    

}   