package com.sd.brigadeiria.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/logar")
    public String home() {
        return "logar";
    }

    @GetMapping("/principal")
    public String principal() {
       return "index";
    }

   
}