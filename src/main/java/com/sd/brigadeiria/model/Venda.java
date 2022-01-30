package com.sd.brigadeiria.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Venda {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "venda_id")
    private Long id;

    @Column
    private Date data;

    @Column
    @OneToMany
    private List<Produto> pedido;

    @Column
    private BigDecimal valorPedido;

    
    @OneToOne
    private Cliente cliente;

    public Venda(){

    }

    public Venda(Date data, List<Produto> pedido, BigDecimal  valorPedido, Cliente cliente){
        this.data = data;
        this.pedido = pedido;
        this.cliente = cliente;
        this.valorPedido = valorPedido;
    }

    public Date getData() {
        return data;
    }
    public BigDecimal getValorPedido() {
        return valorPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setValorPedido(BigDecimal valorPedido) {
        this.valorPedido = valorPedido;
    }
    public List<Produto> getPedido() {
        return pedido;
    }
    public void setPedido(List<Produto> pedido) {
        this.pedido = pedido;
    }
    public void setData(Date data) {
        this.data = data;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



    


}
