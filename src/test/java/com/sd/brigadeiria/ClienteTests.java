package com.sd.brigadeiria;

import com.sd.brigadeiria.model.Cliente;
import com.sd.brigadeiria.repository.ClienteRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTests{

    @Autowired
    private ClienteRepository cliRepository;

    @Test
    public void salvarCliente() {
        Cliente cliente = new Cliente((long) 1, "Patrícia", "01700000000", "33360000", "Física",
        "Rua Teste", "teste@email.com");
        cliRepository.save(cliente);
    }
}