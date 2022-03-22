package com.sd.brigadeiria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Sabor {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "sabor_id")
    private Long id;

    @Column
    private String nome;

    @ManyToOne
    private Produto produto;

    public Sabor(){

    }

    public Sabor(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }




}
