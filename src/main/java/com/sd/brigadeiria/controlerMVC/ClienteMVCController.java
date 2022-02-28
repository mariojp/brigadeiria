package com.sd.brigadeiria.controlerMVC;


import java.util.List;
import java.util.Optional;

import com.sd.brigadeiria.model.Cliente;
import com.sd.brigadeiria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ClienteMVCController {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @GetMapping("/novocliente")
    public String novoCliPage(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);

        return "cliente/clienteform";
    }
    
    @GetMapping("/listaclientesm")
    public String listaClientes(Model model){
        model.addAttribute("lista", clienteRepository.findAll());
        return "cliente/clientes";
    }

    @PostMapping("/salvarclientesm")
    public String salvar(Cliente cliente){
        List<Cliente> clientes = listaClientePorCPF(cliente.getCpf());
        if (clientes.isEmpty()){
            clienteRepository.save(cliente);
            return "cliente/clientes";
        }

        return "erro";
        
    }

    
    @GetMapping("/excluirclientesm")
    public String excluir( @RequestParam long id){
       
        clienteRepository.deleteById(id);
        return "cliente/clientes";
     }

     @GetMapping("/editarclientesm")
    public String mostrarEditForm(@RequestParam long id, Model model){

        try {
            Optional<Cliente> cliente = listaClientesPorId(id);
            model.addAttribute("cli", cliente);
            return "cliente/editclienteform";
        } catch (ClienteNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "erro";
        
        }

    }

    public List<Cliente> listaClientePorCPF(String cpf){
        List<Cliente> lista = clienteRepository.findByCpf(cpf);
        return lista;
    }

    
    public Optional<Cliente> listaClientesPorId(Long id) throws ClienteNotFoundException {     
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isPresent()){
         return cliente;
        }
        throw new ClienteNotFoundException("Cliente não pode ser encontrado");
    }


    

}   