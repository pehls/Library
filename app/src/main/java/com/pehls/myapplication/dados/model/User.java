package com.pehls.myapplication.dados.model;

public class User {
    private String user ;
    private String senha = "1";

    public User(String user) {
        this.user = user;
    }

    public String getSenha() {

        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
