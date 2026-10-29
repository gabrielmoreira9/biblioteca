package com.estudos.biblioteca_api.service;

import com.estudos.biblioteca_api.model.Livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LivroService {

    private final Map <Long, Livro> livros;

    public LivroService(Map<Long, Livro> livros){
        this.livros = livros;
    }

    public List <Livro> listarLivro(){
        return new ArrayList<>(livros.values());
    }

    public Livro buscarPorId(long id){
        return livros.get(id);
        }
    }