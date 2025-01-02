package com.example.BookMyShow.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class City extends BaseModel{

    private String name;

    @OneToMany(mappedBy = "city" , orphanRemoval = true , fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Theatre> theatres;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(List<Theatre> theatres) {
        this.theatres = theatres;
    }
}