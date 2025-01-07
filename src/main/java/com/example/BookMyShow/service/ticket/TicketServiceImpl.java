package com.example.BookMyShow.service.ticket;

import com.example.BookMyShow.exceptions.MovieNotFoundException;
import com.example.BookMyShow.exceptions.SeatNotFoundException;
import com.example.BookMyShow.exceptions.ShowNotFoundException;
import com.example.BookMyShow.exceptions.UserNotFoundException;
import com.example.BookMyShow.models.*;
import com.example.BookMyShow.repository.*;
import com.example.BookMyShow.service.EmailService.EmailService;
//import com.example.BookMyShow.service.PDFGenerator;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ShowSeatRepo showSeatRepo;

    @Autowired
    private TicketRepo ticketRepo;

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private ShowRepo showRepo;

    @Autowired
    private EmailService emailService;

//    @Autowired
//    private PDFGenerator pdfGenerator;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public Ticket bookTicket(int userId, int showId, List<Integer> seatIds, double totalAmount, String ticketStatus) throws UserNotFoundException, SeatNotFoundException, MovieNotFoundException, ShowNotFoundException, FileNotFoundException, MessagingException {

        /*
        1. check if User is Valid user else throw an exception
        2. check the seatIds is Valid else throw and exception
        3. start Transaction
        4. Check the seat is Available if "yes" Blocked the else throw an throw an exception
        5. Create a Ticket Object
        6. Store it in DB return a ticket to client
         */
        Optional<User> user = userRepo.findById(userId);
        if(user.isEmpty()){
            throw new UserNotFoundException("User Not Found");
        }

       List<ShowSeat> showSeats = showSeatRepo.findBySeat_IdInAndSeatStatus(seatIds , SeatStatus.AVAILABLE);
        if(showSeats.size() != seatIds.size()){
            throw new SeatNotFoundException("Seat are unavailable");
        }

        Optional<Show> show = showRepo.findById(showId);


        if(show.isEmpty()){
            throw new ShowNotFoundException("Show Noy Found");
        }
        showSeats.forEach(showSeat -> {
            showSeat.setSeatStatus(SeatStatus.BLOCKED);
            showSeat.setBookBy(user.orElse(null));
        });

        Ticket ticket = new Ticket();

        ticket.setUser(user.orElse(null));
        ticket.setShowSeats(showSeats);
        ticket.setTotal_amount(totalAmount);
        ticket.setShow(show.orElse(null));
        ticket.setTicketStatus(TicketStatus.PENDING);

        Ticket savedTicket = ticketRepo.save(ticket);

        if(savedTicket == null){
            throw new RuntimeException("Ticket Not Created");
        }

        showSeats.forEach(showSeat -> showSeat.setTicket(savedTicket));
        showSeatRepo.saveAll(showSeats);

//        String pdf = PDFGenerator.generateTicketPDF(ticket);
//
//        String ToEmail = ticket.getUser().getEmail();
//        emailService.sendEmail(ToEmail ,
//                "Your TicketConfirmation " ,
//                "Please find your ticket attached.",
//                pdf);
        return ticket;
    }
}