package com.example.BookMyShow.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "show_seats")
public class ShowSeat extends BaseModel{

    @ManyToOne
    private User bookBy;

    @ManyToOne
    private Seat seat;

    @Enumerated(EnumType.STRING) // Ensures that SeatStatus is stored as a string
    @Column(name = "seat_status") // Optional if the column name is different
    private SeatStatus seatStatus;


    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;

    @ManyToOne
    @JoinColumn(name = "ticket_id")
    @JsonBackReference
    private Ticket ticket;


    public User getBookBy() {
        return bookBy;
    }

    public void setBookBy(User bookBy) {
        this.bookBy = bookBy;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

}