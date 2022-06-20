package com.sd.brigadeiria.mvc;

import java.math.BigDecimal;
import java.util.List;
import com.sd.brigadeiria.model.Categoria;
import com.sd.brigadeiria.model.Cliente;
import com.sd.brigadeiria.model.Pedido;
import com.sd.brigadeiria.model.Status;
import com.sd.brigadeiria.repository.CategoriaRepository;
import com.sd.brigadeiria.repository.ClienteRepository;
import com.sd.brigadeiria.repository.PedidoRepository;
import com.sd.brigadeiria.service.ItemPedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/pedido")
public class PedidoMVCController {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ItemPedidoService itemPedidoService;

    private BigDecimal valorPedido  = new BigDecimal(0);


    @GetMapping("novo")
    public String novoFormPedido(Model model){
        List<Categoria> categorias = categoriaRepository.findAll();
        model.addAttribute("categorias", categorias);
        List<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "/pedido/pedidoform";
    }
    
    @GetMapping("/listar")
    public String listaVenda(Model model){
        model.addAttribute("pedidos", pedidoRepository.findAll());
        return "pedido/pedidos";
    }

    @PostMapping("/salvar")
    public void salvar(Pedido pedido, Model model){
        
        valorPedido = itemPedidoService.getValorPedido();

        pedido.setValorPedido(valorPedido);
        pedido.setStatus(Status.ABERTO);
        pedidoRepository.save(pedido);
        itemPedidoService.salvar(pedido);
        System.out.println("pedido salvo");
    }

    @GetMapping("/excluir")
    public String excluir(@RequestParam long id, Model model){
        pedidoRepository.deleteById(id); 
        model.addAttribute("pedidos", pedidoRepository.findAll());
        return "pedido/pedidos";
    }




}
