package com.example.BookMyShow.service.ticket;

import com.example.BookMyShow.exceptions.SeatNotFoundException;
import com.example.BookMyShow.exceptions.UserNotFoundException;
import com.example.BookMyShow.models.Ticket;

import java.util.List;

public interface TicketService {
    public Ticket bookTicket(List<Integer> showSeatIds ,  int userId) throws UserNotFoundException, SeatNotFoundException;
}