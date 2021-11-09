package com.sd.brigadeiria.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.sd.brigadeiria.model.Cliente;
import com.sd.brigadeiria.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @GetMapping(value="/clientes")
    public List<Cliente> listaClientes(){
        List<Cliente> lista = clienteRepository.findAll();
        return lista;
    }
    
}
