package com.estudos.biblioteca_api.controller;

import com.estudos.biblioteca_api.service.LivroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.estudos.biblioteca_api.model.Livro;
import java.util.List;
import java.util.ArrayList;

@RestController
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping("/livros")
    public List<Livro> getLivros() {
        return livroService.listarLivro();
    }

    @GetMapping("/livros/{id}")
    public Livro buscarLivro(@PathVariable Long id) {
        return livroService.buscarPorId(id);
    }
}
