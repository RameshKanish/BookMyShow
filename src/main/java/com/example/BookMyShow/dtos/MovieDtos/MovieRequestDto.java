package com.example.BookMyShow.dtos.MovieDtos;

import com.example.BookMyShow.models.Genre;

public class MovieRequestDto {

    private String movieName ;
    private Genre genre;

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
