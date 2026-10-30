package com.estudos.biblioteca_api.repository;

import com.estudos.biblioteca_api.model.Livro;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Testcontainers
@DataJpaTest
public class LivroRepositorioTest {
    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:17");
    @Autowired
    private LivroRepositorio livroRepositorio;
    @Autowired
    private EntityManager entityManager;

    @Test
    void deveSalvarLivro(){
        Livro livro = new Livro("O Hobbit", "J.R.R. Tolkien", 1937);
        Livro resultado = livroRepositorio.save(livro);
        assertNotNull(resultado.getId());
        assertEquals("O Hobbit", resultado.getTitulo());
    }

    @Test
    void deveSalvarEBuscarLivro(){
        Livro livro = new Livro ("1984", "George Orwell", 1949);
        Livro LivroSalvo = livroRepositorio.save(livro);
        Optional<Livro> resultado = livroRepositorio.findById(LivroSalvo.getId());
        assertTrue(resultado.isPresent());
        assertEquals("1984", resultado.get().getTitulo());
    }

    @Test
    void deveAtualizarlivro(){
        Livro livro = new Livro("1984", "George Orwell", 1949);
        Livro livroSalvo = livroRepositorio.save(livro);

        livroSalvo.setTitulo("A Revolução dos Bichos");
        livroRepositorio.save(livroSalvo);

        entityManager.flush();
        entityManager.clear();

        Livro resultado = livroRepositorio.findById(livroSalvo.getId()).orElseThrow();
        assertEquals("A Revolução dos Bichos", resultado.getTitulo());
    }

    @Test
    void deveExcluirLivro(){
        Livro livro = new Livro("O Hobbit", "J.R.R. Tolkien", 1937);
        Livro livroSalvo = livroRepositorio.save(livro);
        Long id = livroSalvo.getId();
        livroRepositorio.deleteById(id);
        livroRepositorio.flush();
        entityManager.clear();
        assertFalse(livroRepositorio.findById(id).isPresent());
    }
}