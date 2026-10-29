package com.estudos.biblioteca_api.config;

import com.estudos.biblioteca_api.model.Livro;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class LivroConfig {

    @Bean
    public Map<Long, Livro> livros() {

        Map<Long, Livro> mapa = new ConcurrentHashMap<>();

        mapa.put(1L, new Livro(1L, "Dom Casmurro", "Machado de Assis", 1899));
        mapa.put(2L, new Livro(2L, "O Senhor dos Anéis", "J.R.R. Tolkien", 1954));
        mapa.put(3L, new Livro(3L, "1984", "George Orwell", 1949));
        mapa.put(4L, new Livro(4L, "A Revolução dos Bichos", "George Orwell", 1945));

        return mapa;
    }
}