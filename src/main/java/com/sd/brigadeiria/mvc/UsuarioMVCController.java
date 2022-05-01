package com.sd.brigadeiria.mvc;

import java.util.Optional;

import com.sd.brigadeiria.model.Usuario;
import com.sd.brigadeiria.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/usuario")
public class UsuarioMVCController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/novo")
    public String form(Usuario usuario){
        return "usuario/usuarioform";

    }

    @PostMapping("/salvar")
    public String salvar(Usuario usuario, Model model){
        String encodedPassword = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode(usuario.getPassword());
        usuario.setPassword(encodedPassword);
        usuarioRepository.save(usuario);
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "usuario/usuarios";
    }

    @GetMapping("/listar")
    public String listar(Model model){
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "usuario/usuarios";
    }

    @GetMapping("/excluir")
    public String excluir( @RequestParam long id, Model model){
       
        usuarioRepository.deleteById(id);
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "usuario/usuarios";
     }

    @GetMapping("/editar")
    public String mostrarEditForm(@RequestParam long id, Model model){
        
        try {
            Optional<Usuario> usuario = usuarioRepository.findById(id);
            model.addAttribute("usuario", usuario);
            return "usuario/usuarioform";
        } catch (Exception e) {
            e.printStackTrace();
            return "erro";
        
        }
    }
    
     
    
}