package ar.com.wolox.test.domain;

import com.google.gson.JsonObject;
import io.github.jhipster.service.filter.StringFilter;

public class Photo {

    private long albumId;

    private long id;

    private String title;

    private String url;

    private String thumbnailUrl;

    public long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(long albumId) {
        this.albumId = albumId;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    //constructor photo
    public Photo(JsonObject jsonObject){
        this.id = jsonObject.get("id").getAsInt();
        this.albumId = jsonObject.get("albumId").getAsInt();
        this.title = jsonObject.get("title").getAsString();
        this.url = jsonObject.get("url").getAsString();
        this.thumbnailUrl = jsonObject.get("thumbnailUrl").getAsString();
    }
}
