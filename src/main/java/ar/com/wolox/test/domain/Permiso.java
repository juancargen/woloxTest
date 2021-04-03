package ar.com.wolox.test.domain;

import com.google.gson.JsonObject;

public class Permiso {

    private long id;

    private long usuarioId;

    private long albumId;

    private String permiso;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public Permiso(JsonObject jsonObject){
        this.id = jsonObject.get("id").getAsInt();
        this.usuarioId = jsonObject.get("usuarioId").getAsInt();
        this.albumId = jsonObject.get("albumId").getAsInt();
        this.permiso = jsonObject.get("permiso").getAsString();

    }
}
