package com.estudos.biblioteca_api.repository;

import com.estudos.biblioteca_api.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepositorio extends JpaRepository<Livro, Long> {
}
