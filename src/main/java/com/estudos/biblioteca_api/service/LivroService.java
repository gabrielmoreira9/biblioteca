package com.estudos.biblioteca_api.service;

import com.estudos.biblioteca_api.model.Livro;
import com.estudos.biblioteca_api.repository.LivroRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepositorio livroRepositorio;

    public LivroService(LivroRepositorio livroRepositorio){
        this.livroRepositorio = livroRepositorio;
    }

    public List <Livro> listarLivro(){
        return livroRepositorio.findAll();
    }

    public Livro buscarPorId(long id) {
        return livroRepositorio.findById(id).orElse(null);
    }

        public Livro salvarlivro(Livro livro){
            return livroRepositorio.save(livro);
        }

        public boolean excluirLivro(Long id) {

        if (!livroRepositorio.existsById(id)) {
            return false;
        }

        livroRepositorio.deleteById(id);
        return true;
    }

    public Livro atualizarLivro(Long id, Livro dadosAtualizados) {

        Livro livro = livroRepositorio.findById(id).orElse(null);

        if (livro == null) {
            return null;
        }

        livro.setTitulo(dadosAtualizados.getTitulo());
        livro.setAutor(dadosAtualizados.getAutor());
        livro.setAnopublicacao(dadosAtualizados.getAnopublicacao());

        return livroRepositorio.save(livro);
    }
}