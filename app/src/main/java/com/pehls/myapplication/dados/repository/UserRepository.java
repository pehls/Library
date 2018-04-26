package com.pehls.myapplication.dados.repository;

import com.pehls.myapplication.dados.dao.UserDao;
import com.pehls.myapplication.dados.model.User;

public class UserRepository {
    public static User getUser(String name) {
        return UserDao.getUser(name);
    }
    public static boolean newUser(String name, String senha) {
        return UserDao.newUser(name, senha);
    }
}
