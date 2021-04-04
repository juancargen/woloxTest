package ar.com.wolox.test.service;

import ar.com.wolox.test.domain.*;
import ar.com.wolox.test.repository.TestRepository;
import com.google.gson.JsonParser;
import com.google.gson.*;
import jdk.nashorn.api.scripting.URLReader;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TestService implements TestRepository {
    private static URL urlUsers = null;
    private static URL urlAlbums = null;
    private static URL urlPhotos = null;
    private static URL urlComments = null;
    private static URL urlPermisos = null;

    static {
        try {
            urlUsers = new URL("https://jsonplaceholder.typicode.com/users");
            urlAlbums = new URL("https://jsonplaceholder.typicode.com/albums");
            urlPhotos = new URL("https://jsonplaceholder.typicode.com/photos");
            urlComments = new URL("https://jsonplaceholder.typicode.com/comments");
            urlPermisos = new URL("http://localhost:3000/permiso");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //private static final String filePath = new String("/Volumes/Data/datos/users.json");

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public List<Permiso> obtenerPermisos() {
        List<Permiso> list = new ArrayList<Permiso>();
        Permiso permiso;

        try {
            JsonParser jsonParser = new JsonParser();
            //Object object = jsonParser.parse(new FileReader(filePath));
            Object object = jsonParser.parse(new URLReader(urlPermisos));
            JsonArray jsonArray = (JsonArray) object;

            System.out.println("Permisos: ");
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = (JsonObject) jsonArray.get(i);
                permiso = new Permiso(jsonObject);
                System.out.println(jsonObject);
                list.add(permiso);
            }
            System.out.println("----------------------------------------------------------");


        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            return list;
        }
    }

    @Override
    public List<User> obtenerUsersPermiso(String permiso, String albumId) {
        List<User> list = new ArrayList<User>();
        User user;

        try{
            ArrayList arrayListUserId = new ArrayList();
            JsonParser jsonParser = new JsonParser();
            Object object = jsonParser.parse(new URLReader(urlPermisos));
            JsonArray jsonArray = (JsonArray) object;

            for (int i=0; i<jsonArray.size();i++){
                JsonObject jsonObject = (JsonObject) jsonArray.get(i);
                //preguntar por el permiso determinado y album especifico
                //para capturar los userIds
                if(jsonObject.get("permiso").toString().contains(permiso) && jsonObject.get("albumId").toString().equals(albumId)){
                    //se obtiene el userId de la condicion especifica
                    arrayListUserId.add(jsonObject.get("usuarioId").toString());
                }
            }

            System.out.println("Usuarios Id para permisos: ");
            for (int i =0;i<arrayListUserId.size(); i++){
                System.out.println(arrayListUserId.get(i));
            }

            //ahora debo recorrer los usuarios para mostrar
            object = jsonParser.parse(new URLReader(urlUsers));
            jsonArray = (JsonArray) object;

            System.out.println("Users Permiso y Album: ");
            for (int i=0;i<jsonArray.size();i++){
                JsonObject jsonObjectUsers = (JsonObject) jsonArray.get(i);
                for(int j=0;j<arrayListUserId.size();j++){
                    //si el userId coincide con el userid del array
                    if(jsonObjectUsers.get("id").toString().equals(arrayListUserId.get(j))){
                        System.out.println(jsonObjectUsers);
                        user = new User(jsonObjectUsers);
                        list.add(user);
                    }
                }
            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            return list;
        }
    }

    @Override
    public Permiso obtenerPermiso(Long id) {
        Permiso permiso = new Permiso();

        try {
            JsonParser jsonParser = new JsonParser();
            //Object object = jsonParser.parse(new FileReader(filePath));
            Object object = jsonParser.parse(new URLReader(urlPermisos));
            JsonArray jsonArray = (JsonArray) object;

            System.out.println("Permiso id: ");
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject jsonObject = (JsonObject) jsonArray.get(i);

                if (jsonObject.get("id").equals(id)){
                    permiso = new Permiso(jsonObject);
                    System.out.println(jsonObject);
                    break;
                }
            }
            System.out.println("----------------------------------------------------------");
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }finally {
            return permiso;
        }
    }

    @Override
    public Permiso createPermiso(Permiso permiso) throws IOException {
        try {
            Map<String, Object> params = new LinkedHashMap<>();

            params.put("id", permiso.getId());
            params.put("usuarioId", permiso.getUsuarioId());
            params.put("albumId", permiso.getAlbumId());
            params.put("permiso", permiso.getPermiso());

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0)
                    postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(param.getValue()),
                    "UTF-8"));
            }
            byte[] postDataBytes = postData.toString().getBytes("UTF-8");

            //Permiso result = testService.save(pais);
            URL url = new URL(urlPermisos.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type",
                "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length",
                String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            return permiso;
        }
    }

    @Override
    public Permiso updatePermiso(Permiso permiso) throws IOException {
        return null;
    }
}
