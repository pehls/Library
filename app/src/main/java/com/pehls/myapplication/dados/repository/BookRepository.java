package com.pehls.myapplication.dados.repository;

import com.pehls.myapplication.dados.dao.BookDao;
import com.pehls.myapplication.dados.model.Book;

public class BookRepository {
    public static Book getBook(String name) {
        return BookDao.getBook(name);
    }
    public static boolean newBook(String name, String autor) {
        return BookDao.newBook(name);
    }
}
