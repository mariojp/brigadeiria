package com.sd.brigadeiria.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "produtos")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "produto_id")
    private Long id;

    @Column
    private String nome;

    @Column
    private String tamanho;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @Column
    @OneToMany
    private List<Sabor> sabores;

    @Column
    //Uso do tipo BigDecimal para representação do valor monetário
    private BigDecimal precoVenda;

    @Column
    //Uso do tipo BigDecimal para representação do valor monetário
    private BigDecimal precoRevenda;

    public Produto(){

    }

    public Produto(String nome, List<Sabor> sabores, BigDecimal  preco){
        this.nome = nome;
        this.sabores = sabores;
        this.precoVenda = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }
    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }
    public List<Sabor> getSabores() {
        return sabores;
    }
    public void setSabores(List<Sabor> sabores) {
        this.sabores = sabores;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPrecoRevenda() {
        return precoRevenda;
    }

    public void setPrecoRevenda(BigDecimal precoRevenda) {
        this.precoRevenda = precoRevenda;
    }

    
    
}
