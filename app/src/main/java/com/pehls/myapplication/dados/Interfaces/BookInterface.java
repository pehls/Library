package com.pehls.myapplication.dados.Interfaces;

public interface BookInterface {
    String getNome();

    boolean setNome(String nome);

    String getAutor();

    boolean setAutor(String autor);

    String getThumbnail() throws Exception;

    boolean setThumbnail(String thumbnail);

    String getDescription();

    boolean setDescription(String description);

    int getId();

    boolean setId(int id);

    @Override
    String toString();
}
