package com.example.BookMyShow.service.ticket;

import com.example.BookMyShow.exceptions.MovieNotFoundException;
import com.example.BookMyShow.exceptions.SeatNotFoundException;
import com.example.BookMyShow.exceptions.ShowNotFoundException;
import com.example.BookMyShow.exceptions.UserNotFoundException;
import com.example.BookMyShow.models.Ticket;
import jakarta.mail.MessagingException;

import java.io.FileNotFoundException;
import java.util.List;

public interface TicketService {
    public Ticket bookTicket(int userId , int showId , List<Integer> seatIds ,double totalAmount ,String ticketStatus) throws UserNotFoundException, SeatNotFoundException, MovieNotFoundException, ShowNotFoundException, FileNotFoundException, MessagingException;
}