package com.sd.brigadeiria.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table
@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "produto_id")
    private Long id;

    @Column
    private String nome;

    @Column
    @OneToMany
    private List<Sabor> sabores;

    @Column
    private int precoVenda;

    public Produto(){

    }

    public Produto(String nome, List<Sabor> sabores, int preco){
        this.nome = nome;
        this.sabores = sabores;
        this.precoVenda = preco;
    }

    public String getNome() {
        return nome;
    }
    public int getPrecoVenda() {
        return precoVenda;
    }
    public void setPrecoVenda(int precoVenda) {
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
}
