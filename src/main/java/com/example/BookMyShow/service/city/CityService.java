package com.example.BookMyShow.service.city;

import com.example.BookMyShow.models.City;

import java.util.List;

public interface CityService {
    public City createCity(String name);
    public List<City> getAllCity();
}