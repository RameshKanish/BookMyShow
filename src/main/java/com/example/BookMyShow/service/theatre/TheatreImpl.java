package com.example.BookMyShow.service.theatre;

import com.example.BookMyShow.exceptions.CityNotFoundException;
import com.example.BookMyShow.models.City;
import com.example.BookMyShow.models.Theatre;
import com.example.BookMyShow.repository.CityRepo;
import com.example.BookMyShow.repository.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheatreImpl implements TheatreService{

    @Autowired
    private TheatreRepo theatreRepo;

    @Autowired
    private CityRepo cityRepo;

    @Override
    public Theatre createTheatre(String name, String address, int cityId) throws CityNotFoundException {

        Optional<City> cityDetails = cityRepo.findById(cityId);

        if(cityDetails.isEmpty()){
            throw new CityNotFoundException("City Not Found");
        }
        City city = cityDetails.get();

        Theatre theatre = new Theatre();

        theatre.setName(name);
        theatre.setAddress(address);
        theatre.setCity(city);
        return theatreRepo.save(theatre);
    }

    @Override
    public List<Theatre> getAllTheatre() {
        List<Theatre> theatres = theatreRepo.findAll();
        return theatres;
    }
}
