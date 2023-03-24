package com.anime.onepiece.model;

public class Character {
    private Integer idCharacter;
    private String url;
    private String imageUrl;
    private String name;
    private String role;

    public Character() {
    }

    public Character(Integer idCharacter, String url, String imageUrl, String name, String role) {
        this.idCharacter = idCharacter;
        this.url = url;
        this.imageUrl = imageUrl;
        this.name = name;
        this.role = role;
    }

    public Integer getIdCharacter() {
        return idCharacter;
    }

    public void setIdCharacter(Integer idCharacter) {
        this.idCharacter = idCharacter;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
