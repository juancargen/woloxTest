package ar.com.wolox.test.domain;

import com.google.gson.JsonObject;

public class Album {


    private long userId;

    private long id;

    private String title;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //constructor Album
    public Album(JsonObject jsonObject){
        this.title = jsonObject.get("title").getAsString();
        this.id = jsonObject.get("id").getAsInt();
        this.userId = jsonObject.get("userId").getAsInt();

    }
}
