package com.example.BookMyShow.controller;

import com.example.BookMyShow.dtos.ticketsDtos.TicketRequestDto;
import com.example.BookMyShow.exceptions.MovieNotFoundException;
import com.example.BookMyShow.exceptions.SeatNotFoundException;
import com.example.BookMyShow.exceptions.ShowNotFoundException;
import com.example.BookMyShow.exceptions.UserNotFoundException;
import com.example.BookMyShow.models.Ticket;
import com.example.BookMyShow.service.ticket.TicketService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/book")
public class TicketController{


    @Autowired
    private TicketService ticketService;

    @PostMapping("/createBooking")

    public ResponseEntity<Ticket> bookTicket(@RequestBody TicketRequestDto ticketRequestDto) throws UserNotFoundException, SeatNotFoundException, MovieNotFoundException, ShowNotFoundException, MessagingException, FileNotFoundException {
        Ticket ticket = ticketService.bookTicket(ticketRequestDto.getUserId(), ticketRequestDto.getShowId() , ticketRequestDto.getSeatIds() , ticketRequestDto.getTotalAmount() , ticketRequestDto.getTicketStatus());
        return new ResponseEntity<>(ticket , HttpStatus.CREATED);
    }
}