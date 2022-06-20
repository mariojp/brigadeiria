package com.sd.brigadeiria.dto;

public class PedidoDto{

    private String valorPedido;
    private String quantidade;
    private String produto;
    private String tamanho;
    
    public String getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }
    public String getProduto() {
        return produto;
    }
    public void setProduto(String produto) {
        this.produto = produto;
    }
    public String getTamanho() {
        return tamanho;
    }
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }
    public String getValorPedido() {
        return valorPedido;
    }
    public void setValorPedido(String valorPedido) {
        this.valorPedido = valorPedido;
    }

    

}
