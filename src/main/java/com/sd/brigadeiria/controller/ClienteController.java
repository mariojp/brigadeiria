package com.sd.brigadeiria.controller;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

import com.sd.brigadeiria.model.Cliente;
import com.sd.brigadeiria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @GetMapping("/clientes")
    public List<Cliente> listaClientes(){
        List<Cliente> lista = clienteRepository.findAll();
        return lista;
    }

    
    /*Exemplo de passagem de parâmetro
    Na url ?tipo= */
    @GetMapping("/clientesportipo" )
    public List<Cliente> listaClientesPorTipo(@RequestParam String tipo) {     
        List<Cliente> lista = clienteRepository.findByTipo(tipo);
        return lista;
    }

    
    @GetMapping("/clienteporcpf" )
    public List<Cliente> listaClientePorCPF(@RequestParam String cpf){
        List<Cliente> lista = clienteRepository.findByCpf(cpf);
        return lista;
    }
      
}
