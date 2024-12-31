package com.example.BookMyShow.service.movie;

import com.example.BookMyShow.exceptions.MovieNotFoundException;
import com.example.BookMyShow.models.Genre;
import com.example.BookMyShow.models.Movie;

import java.util.List;
import java.util.Optional;



public interface MovieService {
    public Movie createMovie(String name , Genre genre);
    public List<Movie> getAllMovies();
    public Movie getOneMovie(int movieId) throws MovieNotFoundException;
    public boolean deleteMovie(int movieId) throws MovieNotFoundException;
}