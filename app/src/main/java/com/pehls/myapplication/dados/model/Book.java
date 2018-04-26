package com.pehls.myapplication.dados.model;

public class Book {
    private String nome;
    private String autor = "Veríssimo";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Book(String nome, String autor) {

        this.nome = nome;
        this.autor = autor;
    }

    public Book(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Livro "+this.nome + " \nAutor:" + this.autor;
    }
}
