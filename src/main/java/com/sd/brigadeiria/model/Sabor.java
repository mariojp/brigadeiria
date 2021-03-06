package com.sd.brigadeiria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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




}
