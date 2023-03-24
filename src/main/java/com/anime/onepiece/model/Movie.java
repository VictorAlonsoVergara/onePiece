package com.anime.onepiece.model;

import java.util.List;

public class Movie {
    private Integer idMovie;
    private String url;
    private String imageUrl;
    private String title;
    //private String duration;
    //private List<String> genres;

    public Movie() {
    }

    public Movie(Integer idMovie, String url, String imageUrl, String title) {
        this.idMovie = idMovie;
        this.url = url;
        this.imageUrl = imageUrl;
        this.title = title;
    }

    public Integer getIdMovie() {
        return idMovie;
    }

    public void setIdMovie(Integer idMovie) {
        this.idMovie = idMovie;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
