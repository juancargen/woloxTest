package ar.com.wolox.test.repository;

import ar.com.wolox.test.domain.*;
import ar.com.wolox.test.service.TestService;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.List;

public interface TestRepository{

    /*
    obtener usuarios
     */
    List<User> obtenerUsers();

    /*
    obtener albumes
     */
    List<Album> obtenerAlbums();

    /*
    obetener albumes de un usuario
     */
    List<Album> obtenerAlbumsUserdI(String userId);

    /*
    obtener fotos
     */
    List<Photo> obtenerPhotos();

    /*
    obtener fotos de un usuario
     */
    List<Photo> obtenerPhotosUserId(String userId);

    /*
    obtener comentarios filtrados por nombre
     */
    List<Comment> obtenerCommentsName(String name);

    /*
    obtener permisos
     */
    List<Permiso> obtenerPermisos();

    /*
    obtener usuarios con un permiso determinado y album especifico
     */
    List<User> obtenerUsersPermiso(String permiso, String albumId);

    /*
    obtener permiso por id
     */
    Permiso obtenerPermiso(Long id);

    /*
    insertar un permiso
     */
    Permiso createPermiso(Permiso permiso) throws IOException;

    /*
    actualizar un permiso
     */
    Permiso updatePermiso(Permiso permiso) throws IOException;



}
