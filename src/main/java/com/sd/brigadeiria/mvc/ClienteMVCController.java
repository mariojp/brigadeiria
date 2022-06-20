package com.sd.brigadeiria.mvc;

import java.util.Optional;
import com.sd.brigadeiria.model.Cliente;
import com.sd.brigadeiria.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/cliente")
public class ClienteMVCController {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    
    @GetMapping("/novo")
    public String form(Cliente cliente) {
        return "/cliente/clienteformtableless";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        return listaClientes(model,1,"nome");
    }
    
    @GetMapping("/listar/{numPagina}")
    public String listaClientes(Model model, @PathVariable("numPagina") int paginaAtual,
                                @Param("campoOrd") String campoOrd ){

        PageRequest pageble = PageRequest.of(paginaAtual-1, 2, Sort.by(Sort.Direction.ASC, campoOrd));
        Page<Cliente> paginaClientes = clienteRepository.findAll(pageble);
        long totalItens = paginaClientes.getTotalElements();
        int totalPaginas = paginaClientes.getTotalPages();

        model.addAttribute("paginaAtual", paginaAtual);
        model.addAttribute("totalItens", totalItens);
        model.addAttribute("totalPaginas", totalPaginas);
        model.addAttribute("lista", paginaClientes );
        model.addAttribute("campoOrd", campoOrd);
        return "cliente/clientes";
    }

    @PostMapping("/salvar")
    public String salvar(Cliente cliente, Model model){

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
        model.addAttribute("lista", clienteRepository.findAll());
        return "cliente/clientes";
    }

    @GetMapping("/excluir")
    public String excluir( @RequestParam long id, Model model){
       
        clienteRepository.deleteById(id);
        model.addAttribute("lista", clienteRepository.findAll());
        return "cliente/clientes";
     }

    @GetMapping("/editar")
    public String mostrarEditForm(@RequestParam long id, Model model){
        
        try {
            Optional<Cliente> cliente = listaClientesPorId(id);
            model.addAttribute("cliente", cliente);
            return "cliente/clienteformtableless";
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

    public Optional<Cliente> listaClientePorNome(String nome) throws ClienteNotFoundException {     
        Optional<Cliente> cliente = clienteRepository.findByNome(nome);
        if(cliente.isPresent()){
         return cliente;
        }
        throw new ClienteNotFoundException("Cliente não pode ser encontrado");
    }

}   