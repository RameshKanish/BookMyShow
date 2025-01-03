package com.example.BookMyShow.controller;


import com.example.BookMyShow.dtos.showseat.ShowSeatRequestDto;
import com.example.BookMyShow.exceptions.SeatNotFoundException;
import com.example.BookMyShow.exceptions.ShowNotFoundException;
import com.example.BookMyShow.models.ShowSeat;
import com.example.BookMyShow.service.showseat.ShowSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("showSeat")
public class SeatShowController {

    @Autowired
    private ShowSeatService showSeatService;

    @PostMapping("/createShowSeat")
    public ResponseEntity<ShowSeat> createShoeSeat(@RequestBody ShowSeatRequestDto showSeatRequestDto) throws ShowNotFoundException, SeatNotFoundException {
        ShowSeat showSeat = showSeatService.createShowSeat(showSeatRequestDto.getSeatId() ,showSeatRequestDto.getShowId());
        return new ResponseEntity<>(showSeat , HttpStatus.CREATED);
    }
}
