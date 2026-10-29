package com.estudos.biblioteca_api.model;

public class Livro {

    private Long id;
    private String titulo;
    private String autor;
    private int anopublicacao;

    public Livro(Long id, String titulo, String autor, int anopublicacao){
        this.id = id;
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
