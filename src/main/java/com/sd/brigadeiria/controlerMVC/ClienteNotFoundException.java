package com.sd.brigadeiria.controlerMVC;

public class ClienteNotFoundException extends Throwable{

    public ClienteNotFoundException(String mensagem){
        super(mensagem);
    }
}
