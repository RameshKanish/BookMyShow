package com.example.BookMyShow.service.ticket;

import com.example.BookMyShow.exceptions.SeatNotFoundException;
import com.example.BookMyShow.exceptions.UserNotFoundException;
import com.example.BookMyShow.models.*;
import com.example.BookMyShow.repository.ShowSeatRepo;
import com.example.BookMyShow.repository.TicketRepo;
import com.example.BookMyShow.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ShowSeatRepo showSeatRepo;

    @Autowired
    private TicketRepo ticketRepo;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public Ticket bookTicket(List<Integer> showSeatIds, int userId) throws UserNotFoundException, SeatNotFoundException {

        /*
        1. check if User is Valid user else throw an exception
        2. check the seatIds is Valid else throw and exception
        3. start Transaction
        4. Check the seat is Available if "yes" Blocked the else throw an throw an exception
        5. Create a Ticket Object
        6. Store it in DB return a ticket to client
         */

        User user = userRepo.findById(userId).orElseThrow(() -> new UserNotFoundException("User is Not Found"));
        List<ShowSeat> showSeats = showSeatRepo.findBySeat_IdInAndSeatStatus(showSeatIds , SeatStatus.AVAILABLE);
        if(showSeatIds.size() != showSeats.size()){
            throw new SeatNotFoundException("This Seat is Blocked By some Users");
        }
        showSeats.forEach(showSeat -> {
            showSeat.setBookBy(user);
            showSeat.setSeatStatus(SeatStatus.BLOCKED);
        });

        Ticket ticket = new Ticket();

        ticket.setUser(user);
        Show show = showSeats.get(0).getShow();
        ticket.setShow(show);
        ticket.setMovie(show.getMovie());
        ticket.setShowSeats(showSeats);
        ticket.setTicketStatus(TicketStatus.PENDING);

        return  ticketRepo.save(ticket);
    }
}