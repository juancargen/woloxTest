package ar.com.wolox.test.repository;

import ar.com.wolox.test.domain.Album;
import ar.com.wolox.test.domain.Comment;
import ar.com.wolox.test.domain.Photo;
import ar.com.wolox.test.domain.User;
import ar.com.wolox.test.service.TestService;

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

}
