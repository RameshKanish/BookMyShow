package com.example.BookMyShow.controller;


import com.example.BookMyShow.dtos.CityDtos.CityRequestDto;
import com.example.BookMyShow.models.City;
import com.example.BookMyShow.service.city.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("city")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("createCity")
    public ResponseEntity<City> createCity (@RequestBody CityRequestDto cityRequestDto) {
        City city = cityService.createCity(cityRequestDto.getName());
        return new ResponseEntity<>(city , HttpStatus.CREATED);
    }
}