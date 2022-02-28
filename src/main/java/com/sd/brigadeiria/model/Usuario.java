package com.sd.brigadeiria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usuario_id")
    private Long id;

    @Email
    @Column
    private String login;

    @Column
    private String senha;

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
  
    public void setLogin(String login) {
        this.login = login;
    }

}
