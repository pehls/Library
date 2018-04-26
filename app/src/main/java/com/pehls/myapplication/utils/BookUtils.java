package com.pehls.myapplication.utils;

import com.pehls.myapplication.dados.model.User;
import com.pehls.myapplication.dados.repository.BookRepository;
import com.pehls.myapplication.dados.repository.UserRepository;

public class BookUtils {

    public BookUtils() {
    }

    public boolean novo (String nome, String autor) {
        return BookRepository.newBook(nome, autor);
    }
}
