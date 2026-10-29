package com.estudos.biblioteca_api.controller;

import com.estudos.biblioteca_api.service.LivroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import com.estudos.biblioteca_api.model.Livro;
import java.util.List;
import java.util.ArrayList;
import java.net.URI;

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

    @PostMapping("/livros")
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody Livro livro) {

        Livro livroSalvo = livroService.salvarlivro(livro);

        return ResponseEntity
                .created(URI.create("/livros/" + livroSalvo.getId()))
                .body(livroSalvo);
    }

    @DeleteMapping("/livros/{id}")
    public ResponseEntity<Void> excluirLivro(@PathVariable Long id) {

        boolean excluido = livroService.excluirLivro(id);

        if (!excluido) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/livros/{id}")
    public ResponseEntity<Livro> atualizarLivro(
            @PathVariable Long id,
            @RequestBody Livro dadosAtualizados) {

        Livro livroAtualizado = livroService.atualizarLivro(id, dadosAtualizados);

        if (livroAtualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(livroAtualizado);
    }
}
