package com.example.BookMyShow.controller;


import com.example.BookMyShow.dtos.showDtos.ShowRequestDto;
import com.example.BookMyShow.exceptions.MovieNotFoundException;
import com.example.BookMyShow.exceptions.ScreenNotFoundException;
import com.example.BookMyShow.models.Show;
import com.example.BookMyShow.service.show.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("show")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/createShow")
    public ResponseEntity<Show> createShow(@RequestBody ShowRequestDto showRequestDto) throws ScreenNotFoundException, MovieNotFoundException {
        Show show = showService.createShow(showRequestDto.getStartTime() , showRequestDto.getMovieId() , showRequestDto.getScreenId());
        return new ResponseEntity<>(show , HttpStatus.CREATED);
    }
}