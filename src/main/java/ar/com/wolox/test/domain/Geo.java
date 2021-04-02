package ar.com.wolox.test.domain;

import com.google.gson.JsonObject;

public class Geo {

    private float lat;

    private float lng;

    public float getLat() {
        return lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    //constructor geo
    public Geo(JsonObject jsonObject){
        this.lat = jsonObject.get("lat").getAsFloat();
        this.lng = jsonObject.get("lng").getAsFloat();

    }
}
