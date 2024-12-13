package com.example.BookMyShow.dtos.MovieDtos;

import com.example.BookMyShow.dtos.ResponseStatus;
import com.example.BookMyShow.models.Movie;

import java.util.List;

public class MovieResponseDto {
    private int movieId;

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    private ResponseStatus responseStatus;

    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
