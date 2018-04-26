package com.pehls.myapplication.dados.dao;

import com.pehls.myapplication.dados.model.User;

public class UserDao {
    public static boolean newUser (String name, String senha) {
        return true;
        /*return false;*/
    }
    public static User getUser (String name) {
        return new User(name);
    }
}
