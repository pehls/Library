package com.pehls.myapplication.dados.dao;

import com.pehls.myapplication.dados.Interfaces.BookInterface;
import com.pehls.myapplication.dados.model.Book;

public class BookDao implements BookInterface{
    public Book book = new Book();
    public void BookDao() {}

    @Override
    public String getNome() {
        return book.getNome();
    }

    @Override
    public boolean setNome(String nome) {
        return book.setNome(nome);
    }

    @Override
    public String getAutor() {
        return book.getAutor();
    }

    @Override
    public boolean setAutor(String autor) {
        return book.setAutor(autor);
    }

    @Override
    public String getThumbnail() throws Exception {
        try {
            return book.getThumbnail();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean setThumbnail(String thumbnail) {
        return book.setThumbnail(thumbnail);
    }

    @Override
    public String getDescription() {
        return book.getDescription();
    }

    @Override
    public boolean setDescription(String description) {
        return book.setDescription(description);
    }

    @Override
    public int getId() {
        return book.getId();
    }

    @Override
    public boolean setId(int id) {
        return book.setId(id);
    }
}
