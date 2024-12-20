package com.example.BookMyShow.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity(name = "movie")
public class Movie extends BaseModel {

    private String name;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    public Movie() {
        this.isDeleted = false; // Default value for new entities.
    }

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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}