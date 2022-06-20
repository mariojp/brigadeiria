package com.sd.brigadeiria;

import com.sd.brigadeiria.model.Usuario;
import com.sd.brigadeiria.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

@SpringBootApplication
public class BrigadeiriaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrigadeiriaApplication.class, args);
	}


	@Bean
	@Profile("Dev")
	CommandLineRunner initWebApplication(UsuarioRepository userRepository) {
		return args -> {
			System.out.println("Run Only dev Profile");

            String encodedPassword = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("password");
            Usuario usuario = new Usuario();
			usuario.setName("teste");
			usuario.setEmail("root@email.com");
			usuario.setPassword(encodedPassword);
            userRepository.save(usuario);
		};
	}


}
