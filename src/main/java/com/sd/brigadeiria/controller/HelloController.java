package com.sd.brigadeiria.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloController {
    
    @GetMapping(value="")
    public String getMethodName() {
        return "Meu teste controller";
    }
    
}
