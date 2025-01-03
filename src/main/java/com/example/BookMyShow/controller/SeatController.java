package com.example.BookMyShow.controller;


import com.example.BookMyShow.dtos.seatRequestDtos.SeatRequest;
import com.example.BookMyShow.exceptions.ScreenNotFoundException;
import com.example.BookMyShow.models.Seat;
import com.example.BookMyShow.service.seat.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("seat")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @PostMapping("createSeat")
    public ResponseEntity<Seat> createSeat(@RequestBody SeatRequest seatRequest) throws ScreenNotFoundException {
        Seat seat = seatService.createSeat(seatRequest.getName() , seatRequest.getRowNum() ,seatRequest.getColNum() ,seatRequest.getSeatType() , seatRequest.getScreenId()) ;
        return new ResponseEntity<>(seat, HttpStatus.CREATED);
    }
}
