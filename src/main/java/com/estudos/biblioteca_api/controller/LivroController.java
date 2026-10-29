package com.estudos.biblioteca_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.estudos.biblioteca_api.model.Livro;

@RestController
public class LivroController {

    @GetMapping("/livros")
    public Livro getLivros(){
        return new Livro(
                1l,
                "Dom Casmurro",
                "Machado de Assis",
                1899
        );
    }
}
