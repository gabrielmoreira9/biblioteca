package com.estudos.biblioteca_api.service;

import com.estudos.biblioteca_api.model.Livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LivroService {

    private final Map<Long, Livro> livros = new HashMap<>(Map.of(
            1L, new Livro(1L, "Dom Casmurro", "Machado de Assis", 1899),
            3L, new Livro(3L, "1984", "George Orwell", 1949),
            2L, new Livro(2L, "O Senhor dos Anéis", "J.R.R. Tolkien", 1954),
            4L, new Livro(4L, "A Revolução dos Bichos", "George Orwell", 1945)
    ));

    public List <Livro> listarLivro(){
        return new ArrayList<>(livros.values());
    }

    public Livro buscarPorId(long id){
        return livros.get(id);
        }
    }