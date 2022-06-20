package com.sd.brigadeiria.api;

import java.math.BigDecimal;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.sd.brigadeiria.dto.PedidoForm;
import com.sd.brigadeiria.model.ItemPedido;
import com.sd.brigadeiria.model.Produto;
import com.sd.brigadeiria.repository.ItemPedidoRepository;
import com.sd.brigadeiria.repository.ProdutoRepository;
import com.sd.brigadeiria.service.ItemPedidoService;

@RestController
@RequestMapping("/api/apiitem")
public class ItemPedidoController {

    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ItemPedidoService itemPedidoService;

    @GetMapping("/listaItens")
    public void listaProdutos(){
        System.out.println("api Item Pedido");
    } 

    @GetMapping("/addItens")
    public String adicionaItem(@RequestParam String quant, @RequestParam String produto, @RequestParam String tamanho){
      
        int quantidade =  Integer.parseInt(quant);
        itemPedidoService.add(quantidade, produto, tamanho);

        BigDecimal valorPedido = itemPedidoService.getValorPedido();
     
        return valorPedido.toString();
    }

    // @PostMapping(path = "/testePost", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    @PostMapping("testePost")
    public void adicionaItemPost(@RequestBody PedidoForm pedidoForm, UriComponentsBuilder URIBulder){
        
        int quantidade =  Integer.parseInt(pedidoForm.getQuantidade());
        itemPedidoService.add(quantidade, pedidoForm.getProduto(), pedidoForm.getTamanho());

        //return  ResponseEntity.ok();
    }

  
}
