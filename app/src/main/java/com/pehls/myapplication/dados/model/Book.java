package com.pehls.myapplication.dados.model;



import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Book {

    int id;
    static private String nome;
    static private String autor = "Ver�ssimo";
    static String thumbnail;
    static String description;


    public Book () {}
    public Book (String nome, String description) {
        this.nome = nome;
        this.description = description;
    }

   
    public String getNome() {
        return nome;
    }

    public String getNomeFormatado() {
        return nome.replace(" ","+");
    }

    
    public boolean setNome(String nome) {
        this.nome = nome;
        return true;
    }

    
    public String getAutor() {
        return autor;
    }

    public String getAutorFormatado() {
        return autor.replace(" ", "+");
    }

    
    public boolean setAutor(String autor) {
        this.autor = autor;
        return true;
    }

    public boolean setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return true;
    }

    public String getDescription() {
        return this.description;
    }

    
    public boolean setDescription(String description) {
        this.description = description;
        return true;
    }

    public int getId() {
        return this.id;
    }

    
    public boolean setId(int id) {
        this.id = id;
        return true;
    }

    
    public String toString() {
        return "Livro "+this.nome + " \nAutor:" + this.autor;
    }
    
    public String getThumbnail() throws Exception {
        /* link:
https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=25822fc6db30d1c8c92d3600ea2e7d5b&tags=jk+rowling&format=json&nojsoncallback=1
        sa�da: json, photos: photo: item 1,
        formato para thumbnail:
        http://c1.staticflickr.com/FARM/server/id_secret_n.jpg
        */
    	if (prepareThumbnail()) {
    		return thumbnail;
    	}
        return ("https://img.elo7.com.br/product/original/8CDDFA/livro-de-presenca-com-caixa-presente-bodas-de-prata.jpg");
    }

    private boolean prepareThumbnail() throws Exception {
    	InputStream response = connectFlickrApi();
		
		try (Scanner scanner = new Scanner(response)) {
			setThumbnail (formatThumbnail(getRandomPhoto(formatApiResponse(scanner))));
			return true;		    
		} catch (Exception ex) {
			return false;
		}
    }
    
	private String formatThumbnail(Photo photo) {
		return "http://c1.staticflickr.com/" + 
						photo.getFarm() + "/" + 
						photo.getServer() + "/" + 
						photo.getId() + "_" + 
						photo.getSecret() + "_n.jpg";
	}
	
	private Photo getRandomPhoto(Collection<Photo> photos) {
		int i = photos.size()/(new Random().nextInt(photos.size()/2));
		Iterator<Photo> iterador = photos.iterator();
		Photo photo = (Photo) iterador.next();
		for (int j = 0; j<=i-1; j++) {
			 photo = (Photo) iterador.next();
		}
		return photo;
	}
	
	private Collection<Photo> formatApiResponse(Scanner scanner) {
		String responseBody = scanner.useDelimiter("\\A").next();
		Api apireal = new Gson().fromJson(responseBody.toString(), Api.class);
		Collection<Photo> photos = apireal.getPhotos().getPhoto();
		return photos;
	}
	
	private InputStream connectFlickrApi() throws IOException, MalformedURLException {
		String initLink = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=d1e2bd43e155361966c561244a4943e5&text=";
        String format = "&format=json&nojsoncallback=1";
        System.out.println(initLink + getNomeFormatado() +format);
		URLConnection connection = new URL(initLink + getNomeFormatado() +format).openConnection();
		InputStream response = connection.getInputStream();
		return response;
	}

}

