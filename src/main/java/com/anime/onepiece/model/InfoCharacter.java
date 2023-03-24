package com.anime.onepiece.model;

import java.util.List;

public class InfoCharacter {
    private String role;
    private Movie movie;

    public InfoCharacter() {
    }

    public InfoCharacter(String role, Movie movie) {
        this.role = role;
        this.movie = movie;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
