package ar.com.wolox.test.domain;

import com.google.gson.JsonObject;

public class Comment {

    private long postId;

    private long id;

    private String name;

    private String email;

    private String body;

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Comment(JsonObject jsonObject){
        this.postId = jsonObject.get("postId").getAsInt();
        this.id = jsonObject.get("id").getAsInt();
        this.name = jsonObject.get("name").getAsString();
        this.email = jsonObject.get("email").getAsString();
        this.body = jsonObject.get("body").getAsString();
    }
}
