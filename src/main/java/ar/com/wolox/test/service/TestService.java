package ar.com.wolox.test.service;

import ar.com.wolox.test.domain.Album;
import ar.com.wolox.test.domain.Comment;
import ar.com.wolox.test.domain.Photo;
import ar.com.wolox.test.domain.User;
import ar.com.wolox.test.repository.TestRepository;
import com.google.gson.JsonParser;
import com.google.gson.*;
import jdk.nashorn.api.scripting.URLReader;


import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class TestService implements TestRepository {
    private static URL urlUsers = null;
    private static URL urlAlbums = null;
    private static URL urlPhotos = null;
    private static URL urlComments = null;

    static {
        try {
            urlUsers = new URL("https://jsonplaceholder.typicode.com/users");
            urlAlbums = new URL("https://jsonplaceholder.typicode.com/albums");
            urlPhotos = new URL("https://jsonplaceholder.typicode.com/photos");
            urlComments = new URL("https://jsonplaceholder.typicode.com/comments");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //private static final String filePath = new String("/Volumes/Data/datos/users.json");

    public List<User> obtenerUsers() {

        List<User> list = new ArrayList<User>();
        User user;
        try {
            JsonParser jsonParser = new JsonParser();
            //Object object = jsonParser.parse(new FileReader(filePath));
            Object object = jsonParser.parse(new URLReader(urlUsers));
            JsonArray jsonArray = (JsonArray) object;

            System.out.println("Users: ");
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = (JsonObject) jsonArray.get(i);
                System.out.println(jsonObject);
                user = new User(jsonObject);
                list.add(user);
            }
            System.out.println("----------------------------------------------------------");
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            return list;
        }

    }

    public List<Album> obtenerAlbums() {

        List<Album> list = new ArrayList<Album>();
        Album album;

        try {
            JsonParser jsonParser = new JsonParser();
            //Object object = jsonParser.parse(new FileReader(filePath));
            Object object = jsonParser.parse(new URLReader(urlAlbums));
            JsonArray jsonArray = (JsonArray) object;

            System.out.println("Albums: ");
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = (JsonObject) jsonArray.get(i);
                album = new Album(jsonObject);
                System.out.println(jsonObject);
                list.add(album);
            }
            System.out.println("----------------------------------------------------------");


        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            return list;
        }

    }

    public List<Album> obtenerAlbumsUserdI(String userId) {

        List<Album> list = new ArrayList<Album>();
        Album album;

        try {
            JsonParser jsonParser = new JsonParser();
            //Object object = jsonParser.parse(new FileReader(filePath));
            Object object = jsonParser.parse(new URLReader(urlAlbums));
            JsonArray jsonArray = (JsonArray) object;

            System.out.println("Albums UserId " + userId + ": ");
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = (JsonObject) jsonArray.get(i);
                if(jsonObject.get("userId").toString().equals(userId)) {
                    album = new Album(jsonObject);
                    System.out.println(jsonObject);
                    list.add(album);
                }
            }
            System.out.println("----------------------------------------------------------");


        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            return list;
        }

    }

    public List<Photo> obtenerPhotos() {

        List<Photo> list = new ArrayList<Photo>();
        Photo photo;

        try {
            JsonParser jsonParser = new JsonParser();
            //Object object = jsonParser.parse(new FileReader(filePath));
            Object object = jsonParser.parse(new URLReader(urlPhotos));
            JsonArray jsonArray = (JsonArray) object;

            System.out.println("Photos: ");
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = (JsonObject) jsonArray.get(i);
                System.out.println(jsonObject);
                photo = new Photo(jsonObject);
                list.add(photo);
            }
            System.out.println("----------------------------------------------------------");
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            return list;
        }

    }

    public List<Photo> obtenerPhotosUserId(String userId) {

        List<Photo> list = new ArrayList<Photo>();
        Photo photo;

        try {
            ArrayList arrayListAlbumsId = new ArrayList();

            JsonParser jsonParser = new JsonParser();
            //Object object = jsonParser.parse(new FileReader(filePath));
            Object object = jsonParser.parse(new URLReader(urlAlbums));
            JsonArray jsonArray = (JsonArray) object;

            //recorrer los albumes y sacar los AlbumesId del usuario
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = (JsonObject) jsonArray.get(i);
                //obtener los albumId del usuario filtrado en un arrayList

                if (jsonObject.get("userId").toString().equals( userId)){
                    arrayListAlbumsId.add(jsonObject.get("id").toString());
                }
            }

            System.out.println("Albums Ids: ");
            for (int j=0; j<arrayListAlbumsId.size();j++){
                System.out.println(arrayListAlbumsId.get(j));
            }

            //recorrer fotos donde AlbumId sea igual al arrayListAlbumId
            Object objectPhotos = jsonParser.parse(new URLReader(urlPhotos));
            JsonArray jsonArrayPhotos = (JsonArray) objectPhotos;

            //recorrer los albumes y sacar los AlbumesId del usuario
            System.out.println("Photos UserId " + userId + ": ");
            for (int i = 0; i < jsonArrayPhotos.size(); i++) {
                JsonObject jsonObjectPhotos = (JsonObject) jsonArrayPhotos.get(i);
                //obtener los albumId del usuario filtrado en un arrayList

                for (int j = 0;j<arrayListAlbumsId.size();j++) {
                    //si el albumId en Photos es igual a albumId en array --> imprima Resultado foto del usuario
                    if (jsonObjectPhotos.get("albumId").toString().equals(arrayListAlbumsId.get(j))) {
                        System.out.println(jsonObjectPhotos);
                        photo = new Photo(jsonObjectPhotos);
                        list.add(photo);
                    }
                }
            }
            System.out.println("----------------------------------------------------------");
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            return list;
        }

    }

    public List<Comment> obtenerCommentsName(String name) {
        List<Comment> list = new ArrayList<Comment>();
        Comment comment;

        try {
            JsonParser jsonParser = new JsonParser();
            //Object object = jsonParser.parse(new FileReader(filePath));
            Object object = jsonParser.parse(new URLReader(urlComments));
            JsonArray jsonArray = (JsonArray) object;

            System.out.println("Comments Name " + name + ": ");
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = (JsonObject) jsonArray.get(i);
                if(jsonObject.get("name").toString().contains(name)) {
                    comment = new Comment(jsonObject);
                    System.out.println(jsonObject);
                    list.add(comment);
                }
            }
            System.out.println("----------------------------------------------------------");


        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            return list;
        }
    }
}
