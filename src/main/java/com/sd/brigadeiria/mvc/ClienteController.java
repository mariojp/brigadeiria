package com.sd.brigadeiria.mvc;


import java.lang.ref.Cleaner.Cleanable;
import java.util.List;
import java.util.Optional;

import com.sd.brigadeiria.model.Cliente;
import com.sd.brigadeiria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/cliente")

public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    
    @GetMapping("/novo")
    public String form(Cliente cliente) {
        return "/cliente/clienteform";
    }
    
    @GetMapping("/listar")
    public String listaClientes(Model model){
        model.addAttribute("lista", clienteRepository.findAll());
        return "cliente/clientes";
    }

    @PostMapping("/salvar")
    public String salvar(Cliente cliente){

        Optional<Cliente> banco = clienteRepository.findByCpf(cliente.getCpf());
        if( banco.isPresent() && cliente.getId() == null ) {
            System.out.println("Cliente novo mas CPF já existe");
            //Cliente novo mas CPF já existe
            return "/erro";
        }else if(banco.isPresent() && cliente.getId() != banco.get().getId() ){
            System.out.println("Editando um cliente mas o cpf já pertence a outro");
            //Editando um cliente mas o cpf já pertence a outro
            return "/erro";
        }
        System.out.println("salvar");
        //outros casos só salvar
        clienteRepository.save(cliente);
        
        return "cliente/clientes";
    }

    
    @GetMapping("/excluirclientesm")
    public String excluir( @RequestParam long id){
       
        clienteRepository.deleteById(id);
        return "cliente/clientes";
     }

     @GetMapping("/editar")
    public String mostrarEditForm(@RequestParam long id, Model model){


        try {
            Optional<Cliente> cliente = listaClientesPorId(id);
            model.addAttribute("cliente", cliente);
            return "cliente/clienteform";
        } catch (ClienteNotFoundException e) {
            e.printStackTrace();
            return "erro";
        
        }

    }



    
    public Optional<Cliente> listaClientesPorId(Long id) throws ClienteNotFoundException {     
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
         return cliente;
        }
        throw new ClienteNotFoundException("Cliente não pode ser encontrado");
    }


    

}   