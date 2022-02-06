package com.sd.brigadeiria.controller;

import com.sd.brigadeiria.model.Cliente;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/casa")
    public String home(ModelMap model) {
        model.addAttribute("nomeDoAtributo", "Treinaweb");

        return "clienteform";
    }

    @GetMapping("/novocliente")
    public String novoCliPage(Model model) {
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);

        return "clienteform";
    }
}