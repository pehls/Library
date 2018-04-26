package com.pehls.myapplication.dados.dao;

import com.pehls.myapplication.dados.model.Book;

public class BookDao {
    public static Book getBook(String nome) {
        return new Book (nome);
    }
    public static boolean newBook(String nome) {
        return true;
    }
}
