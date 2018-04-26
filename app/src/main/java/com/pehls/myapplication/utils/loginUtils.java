package com.pehls.myapplication.utils;

import com.pehls.myapplication.dados.model.User;
import com.pehls.myapplication.dados.repository.UserRepository;

public class loginUtils {
    private String senhaParaConferir = "1";

    public loginUtils() {
        this.senhaParaConferir = "1";
    }

    public boolean confere (String user, String senha) {
        if (senha(user(user)).confere(senha)) {
            return true;
        }
        return false;
    }

    private loginUtils senha (User user) {
        this.senhaParaConferir = user.getSenha();
        return this;
    }
    private User user (String user) {
        return UserRepository.getUser(user);
    }
    private boolean confere(String senha) {
        if (this.senhaParaConferir.equals(senha)) return true;
        return false;
    }
    public boolean novo (String user, String senha) {
        return UserRepository.newUser(user, senha);
    }

    public String imprimir(String nome) {
        return user(nome).getSenha();
    }
}
