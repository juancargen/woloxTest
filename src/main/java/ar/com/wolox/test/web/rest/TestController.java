package ar.com.wolox.test.web.rest;

import ar.com.wolox.test.domain.*;
import ar.com.wolox.test.service.TestService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.io.IOException;
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

    @GetMapping(value = "/permisos")
    public ResponseEntity<List<Permiso>> obtenerPermisos(){
        return ResponseEntity.ok().body(testService.obtenerPermisos());
    }

    @GetMapping(value = "usersPermiso")
    public ResponseEntity<List<User>> obtenerUsersPermiso(@RequestParam(name = "permiso", required = true, defaultValue = "lectura") String permiso, @RequestParam(name = "albumId", required = true, defaultValue = "1") String albumId){
        return ResponseEntity.ok().body(testService.obtenerUsersPermiso(permiso, albumId));
    }

    @PostMapping("/createPermiso")
    public ResponseEntity<Permiso> createPermiso(@Valid @RequestBody Permiso permiso) throws IOException {
        return ResponseEntity.ok().body(testService.createPermiso(permiso));
    }



}
