package com.anime.onepiece.controller;

import com.anime.onepiece.model.Movie;
import com.anime.onepiece.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @CrossOrigin
    @GetMapping("/movies")
    public List<Movie> findAllMovies(){
        List<Movie> movies = movieService.findAllMovies();
        return movies;
    }

}
