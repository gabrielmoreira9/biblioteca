package com.estudos.biblioteca_api.service;

import com.estudos.biblioteca_api.model.Livro;
import com.estudos.biblioteca_api.repository.LivroRepositorio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class LivroServiceTest {

    @Mock
    private LivroRepositorio livroRepositorio;

    @InjectMocks
    private LivroService livroService;

    @Test
    void deveBuscarLivroPorId() {

        Livro livro = new Livro ("O Hobbit", "J.R.R. Tolkien", 1937);

        when(livroRepositorio.findById(1L)).thenReturn(Optional.of(livro));
        Livro resultado = livroService.buscarPorId(1L);
        assertEquals("O Hobbit", resultado.getTitulo());
    }

    @Test
    void deveRetornarNull() {
        when(livroRepositorio.findById(99L)).thenReturn(Optional.empty());
        Livro resultado = livroService.buscarPorId(99L);
        assertEquals(null, resultado);
    }

    @Test
    void deveSalvarLivro() {
        Livro livro = new Livro("O Hobbit", "J.R.R. Tolkien", 1937);
        when(livroRepositorio.save(livro)).thenReturn(livro);
        Livro resultado = livroService.salvarlivro(livro);
        assertEquals(livro, resultado);
        verify(livroRepositorio).save(livro);
        }
    }
