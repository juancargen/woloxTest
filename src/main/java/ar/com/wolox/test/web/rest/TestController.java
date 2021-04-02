package ar.com.wolox.test.web.rest;

import ar.com.wolox.test.domain.Album;
import ar.com.wolox.test.domain.Comment;
import ar.com.wolox.test.domain.Photo;
import ar.com.wolox.test.domain.User;
import ar.com.wolox.test.service.TestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    private final TestService testService = new TestService();

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> obtenerUsuarios(){
        return ResponseEntity.ok().body(testService.obtenerUsers());
    }

    @GetMapping(value = "/albums")
    public ResponseEntity<List<Album>> obtenerAlbumes(){
        return ResponseEntity.ok().body(testService.obtenerAlbums());

    }

    @GetMapping(value = "/albumsUserId")
    public ResponseEntity<List<Album>> obtenerAlbumesUserId(@RequestParam(name="userId", required=true, defaultValue="1")  String userId){
        return ResponseEntity.ok().body(testService.obtenerAlbumsUserdI(userId));

    }

    @GetMapping(value = "/photos")
    public ResponseEntity<List<Photo>> obtenerFotos(){
        return ResponseEntity.ok().body(testService.obtenerPhotos());

    }

    @GetMapping(value = "/photosUserId")
    public ResponseEntity<List<Photo>> obtenerFotosUsuario(@RequestParam(name="userId", required=true, defaultValue="1")  String userId){
        return ResponseEntity.ok().body(testService.obtenerPhotosUserId(userId));

    }

    @GetMapping(value = "/commentsName")
    public ResponseEntity<List<Comment>> obtenerCommentariosNombre(@RequestParam(name="name", required=true, defaultValue="a")  String name){
        return ResponseEntity.ok().body(testService.obtenerCommentsName(name));

    }


}
