package com.sd.brigadeiria.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="pedidos")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pedidos_id")
    private Long id;

    @Column
    private LocalDate data = LocalDate.now();;

    //mappedBy - indica que já foi mapeado do outro lado
    @Column
    @OneToMany(mappedBy= "pedido", cascade = CascadeType.REMOVE)
    private List<ItemPedido> itens;

    @Column
    private BigDecimal valorPedido;

    private  Status status;

    
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @OneToOne
    private Cliente cliente;

    public Pedido(){

    }

    public Pedido( BigDecimal  valorPedido, Cliente cliente){
       // this.produtos = produtos;
        this.cliente = cliente;
        this.valorPedido = valorPedido;
    }

    public LocalDate getData() {
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

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    

    



    


}
