package com.estudos.biblioteca_api.service;

import com.estudos.biblioteca_api.model.Livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    private final List<Livro> livros = new ArrayList<>();

    public LivroService() {
        livros.add(new Livro(1L, "Dom Casmurro", "Machado de Assis", 1899));
        livros.add(new Livro(3L, "1984", "George Orwell", 1949));
        livros.add(new Livro(2l, "O Senhor dos Anéis", "J.R.R. Tolkien", 1954));
        livros.add(new Livro(4l, "A Revolução dos Bichos", "George Orwell", 1945));
    }

    public List <Livro> listarLivro(){
        return livros;
    }

    public Livro buscarPorId(long id){
        for(Livro livro: livros){

            if (livro.getId() == id)
                return livro;
        }
        return null;
    }
}