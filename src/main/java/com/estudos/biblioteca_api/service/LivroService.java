package com.estudos.biblioteca_api.service;

import com.estudos.biblioteca_api.model.Livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LivroService {

    private final Map< Long, Livro> livros = new HashMap<>();

    public LivroService() {
        livros.put(1L, new Livro(1L, "Dom Casmurro", "Machado de Assis", 1899));
        livros.put(3L, new Livro(3L, "1984", "George Orwell", 1949));
        livros.put(2L, new Livro(2l, "O Senhor dos Anéis", "J.R.R. Tolkien", 1954));
        livros.put(4L, new Livro(4l, "A Revolução dos Bichos", "George Orwell", 1945));
    }

    public List <Livro> listarLivro(){
        return new ArrayList<>(livros.values());
    }

    public Livro buscarPorId(long id){
        return livros.get(id);
        }
    }