package com.example.BookMyShow.models;


import jakarta.persistence.Entity;

@Entity(name = "movie")
public class Movie extends BaseModel{
    private String name;
    private Genre genre;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
