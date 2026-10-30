package com.estudos.biblioteca_api.repository;

import com.estudos.biblioteca_api.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.containers.PostgreSQLContainer;
import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@DataJpaTest
public class LivroRepositorioTest {
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:17");
    @Autowired
    private LivroRepositorio livroRepositorio;

    @Test
    void deveSalvarLivro(){
        Livro livro = new Livro("O Hobbit", "J.R.R. Tolkien", 1937);
        Livro resultado = livroRepositorio.save(livro);
        assertNotNull(resultado.getId());
        assertEquals("O Hobbit", resultado.getTitulo());
    }
}
