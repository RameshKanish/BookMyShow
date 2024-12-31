package com.example.BookMyShow.service.city;

import com.example.BookMyShow.models.City;
import com.example.BookMyShow.repository.CityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityImpl implements CityService{

    @Autowired
    private CityRepo cityRepo;

    @Override
    public City createCity(String name) {

        City city = new City();
        city.setName(name);
        cityRepo.save(city);
        return city;
    }

    @Override
    public List<City> getAllCity() {
        return cityRepo.findAll();
    }
}