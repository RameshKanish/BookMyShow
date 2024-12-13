package com.example.BookMyShow.controller;

import com.example.BookMyShow.dtos.ticketsDtos.TicketRequestDto;
import com.example.BookMyShow.exceptions.SeatNotFoundException;
import com.example.BookMyShow.exceptions.UserNotFoundException;
import com.example.BookMyShow.models.Ticket;
import com.example.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class TicketController{


    @Autowired
    private TicketService ticketService;

    @PostMapping("/createBooking")


    public ResponseEntity<Ticket> bookTicket(@RequestBody TicketRequestDto ticketRequestDto) throws UserNotFoundException, SeatNotFoundException {
        Ticket ticket = ticketService.bookTicket(ticketRequestDto.getShowSeats(), ticketRequestDto.getUserId());
        return new ResponseEntity<>(ticket , HttpStatus.CREATED);
    }
}