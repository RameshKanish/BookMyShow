package com.example.BookMyShow.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity(name = "ticket")
public class Ticket extends BaseModel{

    @ManyToOne
    private User user;



    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    @JsonBackReference
    private Show show;

    @OneToMany(mappedBy = "ticket" , orphanRemoval = true)
    @JsonManagedReference
    private List<ShowSeat> showSeats;

    private double total_amount;

    @Enumerated(value = EnumType.ORDINAL)
    private TicketStatus ticketStatus;

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public void setShowSeats(List<ShowSeat> showSeats) {
        this.showSeats = showSeats;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }
}