package com.estudos.biblioteca_api.controller;

import com.estudos.biblioteca_api.service.LivroService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Livro>> getLivros() {
        return ResponseEntity.ok(livroService.listarLivro());
    }

    @GetMapping("/livros/{id}")
    public ResponseEntity <Livro> buscarLivro(@PathVariable Long id) {
        Livro livro = livroService.buscarPorId(id);
        if (livro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(livro);
    }
}
