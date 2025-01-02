package com.example.BookMyShow.service.theatre;

import com.example.BookMyShow.exceptions.CityNotFoundException;
import com.example.BookMyShow.models.Theatre;

import java.util.List;

public interface TheatreService {

    public Theatre createTheatre(String name , String address , int cityId) throws CityNotFoundException;
    public List<Theatre> getAllTheatre();
}
