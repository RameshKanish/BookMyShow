package com.example.BookMyShow.controller;


import com.example.BookMyShow.dtos.screenDtos.ScreenRequestDto;
import com.example.BookMyShow.exceptions.TheatreNotFoundException;
import com.example.BookMyShow.models.Screen;
import com.example.BookMyShow.service.screen.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("screen")
public class ScreenController {

    @Autowired
    private ScreenService screenService;

    @PostMapping("createScreen")
    public ResponseEntity<Screen> createScreen(@RequestBody ScreenRequestDto screenRequestDto) throws TheatreNotFoundException {
        Screen screen = screenService.createScreen(screenRequestDto.getScreenName(), screenRequestDto.getTheatreId());
        return new ResponseEntity<>(screen , HttpStatus.CREATED);
    }

    @GetMapping("getAllScreens")
    public ResponseEntity<List<Screen>> getAllScreen() {
        List<Screen> screenList = screenService.getAllScreen();
        return new ResponseEntity<>(screenList , HttpStatus.FOUND);
    }
}