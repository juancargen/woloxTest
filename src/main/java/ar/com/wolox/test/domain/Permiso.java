package ar.com.wolox.test.domain;

import com.google.gson.JsonObject;

public class Permiso {

    private Long id;

    private Long usuarioId;

    private Long albumId;

    private String permiso;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    //constructores permiso
    public Permiso(JsonObject jsonObject){
        this.id = jsonObject.get("id").getAsLong();
        this.usuarioId = jsonObject.get("usuarioId").getAsLong();
        this.albumId = jsonObject.get("albumId").getAsLong();
        this.permiso = jsonObject.get("permiso").getAsString();

    }
    public Permiso(){

    }
}
