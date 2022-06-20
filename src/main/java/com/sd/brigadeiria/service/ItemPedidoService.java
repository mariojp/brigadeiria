package com.sd.brigadeiria.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.brigadeiria.model.ItemPedido;
import com.sd.brigadeiria.model.Pedido;
import com.sd.brigadeiria.model.Produto;
import com.sd.brigadeiria.repository.ItemPedidoRepository;
import com.sd.brigadeiria.repository.PedidoRepository;
import com.sd.brigadeiria.repository.ProdutoRepository;

@Service
public class ItemPedidoService{

    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    @Autowired
    PedidoRepository pedidoRepository;
    
    @Autowired 
    ProdutoRepository produtoRepository;

    private List<ItemPedido> listaItens = new ArrayList <ItemPedido>();
    
    public List<ItemPedido> getListaItens() {
        return listaItens;
    }

    public void add(int quantidade, String produto, String tamanho){
        ItemPedido item = new ItemPedido();
        Produto produtoItem = produtoRepository.findByNomeAndTamanho(produto, tamanho) ;
        
        item.setQuantidade(quantidade);
        item.setProduto(produtoItem);
        item.setPrecoUnitario(produtoItem.getPrecoVenda());
        listaItens.add(item);
    }

    public BigDecimal getValorPedido(){
        BigDecimal valorPedido = new BigDecimal(0);
        BigDecimal valorItens;

        for (ItemPedido itemAtual : listaItens){
            //itemPedidoRepository.save(itemAtual);

            int  quantidadeItens = itemAtual.getQuantidade();
            BigDecimal quantItensBig = new BigDecimal(quantidadeItens);

            valorItens = itemAtual.getPrecoUnitario().multiply(quantItensBig);
            valorPedido = valorPedido.add(valorItens);
        }

        return valorPedido;
    }

    public void salvar(Pedido pedido){

        for (ItemPedido itemAtual : listaItens){
           itemAtual.setPedido(pedido);
           itemPedidoRepository.save(itemAtual);
        }

        limpaLista();
    }

    public void limpaLista(){
        listaItens.clear();
    }
}