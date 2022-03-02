package com.example.myapplication;

public class User {
    protected String fullname;
    protected String email;
    protected String username;
    protected String image;
    protected String gender;
    protected String key;

    public User(String fullname, String email, String username, String image, String gender, String key) {
        this.fullname = fullname;
        this.email = email;
        this.username = username;
        this.image = image;
        this.gender = gender;
        this.key = key;
    }

    public User() {
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}