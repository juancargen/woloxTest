package ar.com.wolox.test.domain;

import com.google.gson.JsonObject;

public class Company {

    private String name;

    private String catchPhrase;

    private String bs;


    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public Company(JsonObject jsonObject){
        this.name = jsonObject.get("name").getAsString();
        this.catchPhrase = jsonObject.get("catchPhrase").getAsString();
        this.bs = jsonObject.get("bs").getAsString();

    }
}
