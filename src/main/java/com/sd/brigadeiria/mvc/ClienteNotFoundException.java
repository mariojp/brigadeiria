package com.sd.brigadeiria.mvc;

public class ClienteNotFoundException extends Throwable{

    public ClienteNotFoundException(String mensagem){
        super(mensagem);
    }
}
