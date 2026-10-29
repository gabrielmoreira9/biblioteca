package com.estudos.biblioteca_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livro {

    protected Livro(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private int anopublicacao;

    public Livro(String titulo, String autor, int anopublicacao){

        this.titulo = titulo;
        this.autor = autor;
        this.anopublicacao = anopublicacao;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setAnopublicacao(int anopublicacao){
        this.anopublicacao = anopublicacao;
    }

    public Long getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getAutor(){
        return autor;
    }

    public int getAnopublicacao(){
        return anopublicacao;
    }
}
