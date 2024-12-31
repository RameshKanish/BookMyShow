package com.example.BookMyShow.controller;


import com.example.BookMyShow.dtos.theatredtos.TheatreRequestDto;
import com.example.BookMyShow.exceptions.CityNotFoundException;
import com.example.BookMyShow.models.Theatre;
import com.example.BookMyShow.service.theatre.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("theatre")
public class TheatreController {


    @Autowired

    private TheatreService theatreService;
    @PostMapping("createTheatre")
    public ResponseEntity<Theatre> createTheatre(@RequestBody TheatreRequestDto theatreRequestDto) throws CityNotFoundException {
        Theatre theatre = theatreService.createTheatre(theatreRequestDto.getName() , theatreRequestDto.getAddress() ,theatreRequestDto.getCityId());
        return new ResponseEntity<>(theatre , HttpStatus.CREATED);
    }
}