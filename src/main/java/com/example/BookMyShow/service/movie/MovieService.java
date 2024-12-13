package com.example.BookMyShow.service.movie;

import com.example.BookMyShow.models.Genre;
import com.example.BookMyShow.models.Movie;

import java.util.List;

public interface MovieService {
    public Movie createMovie(String name , Genre genre);
    public List<Movie> getAllMovies();
}