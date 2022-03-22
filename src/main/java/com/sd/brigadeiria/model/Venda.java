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
    private List<Produto> produtos;

    @Column
    private BigDecimal valorPedido;

    
    @OneToOne
    private Cliente cliente;

    public Venda(){

    }

    public Venda(Date data, List<Produto> produtos, BigDecimal  valorPedido, Cliente cliente){
        this.data = data;
        this.produtos = produtos;
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
        return produtos;
    }
    public void setPedido(List<Produto> produtos) {
        this.produtos = produtos;
    }
    public void setData(Date data) {
        this.data = data;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



    


}
