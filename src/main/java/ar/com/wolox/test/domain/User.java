package ar.com.wolox.test.domain;

import com.google.gson.JsonObject;

public class User {

    private long id;

    private String name;

    private String username;

    private Address address;

    private String phone;

    private String webSite;

    private Company company;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebSite() {
        return webSite;
    }

    public Company getCompany() {
        return company;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public User(JsonObject jsonObject){
        this.id = jsonObject.get("id").getAsInt();
        this.name = jsonObject.get("name").getAsString();
        this.username = jsonObject.get("username").getAsString();

        this.phone = jsonObject.get("phone").getAsString();
        this.webSite = jsonObject.get("website").getAsString();
        this.address = new Address(jsonObject.getAsJsonObject("address"));
        this.company = new Company(jsonObject.getAsJsonObject("company"));

    }
 }
