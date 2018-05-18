package com.pehls.myapplication.dados.repository;

import com.pehls.myapplication.dados.Interfaces.BookInterface;
import com.pehls.myapplication.dados.dao.BookDao;
import com.pehls.myapplication.dados.model.Book;

public class BookRepository implements BookInterface {
    BookDao dao = new BookDao();
    @Override
    public String getNome() {
        return dao.getNome();
    }

    @Override
    public boolean setNome(String nome) {
        return dao.setNome(nome);
    }

    @Override
    public String getAutor() {
        return dao.getAutor();
    }

    @Override
    public boolean setAutor(String autor) {
        return dao.setAutor(autor);
    }

    @Override
    public String getThumbnail() throws Exception {
        return dao.getThumbnail();
    }

    @Override
    public boolean setThumbnail(String thumbnail) {
        return dao.setThumbnail(thumbnail);
    }

    @Override
    public String getDescription() {
        return dao.getDescription();
    }

    @Override
    public boolean setDescription(String description) {
        return dao.setDescription(description);
    }

    @Override
    public int getId() {
        return dao.getId();
    }

    @Override
    public boolean setId(int id) {
        return dao.setId(id);
    }
}
