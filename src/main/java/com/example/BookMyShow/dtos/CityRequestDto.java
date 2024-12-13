package com.example.BookMyShow.dtos;


import com.example.BookMyShow.models.Theatre;

import java.util.List;

public class CityRequestDto {

    private String name;
    private List<Theatre> theatres;

    public List<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(List<Theatre> theatres) {
        this.theatres = theatres;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}