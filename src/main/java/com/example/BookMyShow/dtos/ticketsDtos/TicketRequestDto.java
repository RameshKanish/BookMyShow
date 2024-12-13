package com.example.BookMyShow.dtos.ticketsDtos;

import java.util.List;



public class TicketRequestDto {

    private List<Integer> showSeats;
    private int userId;

    public List<Integer> getShowSeats() {
        return showSeats;
    }

    public void setShowSeats(List<Integer> showSeats) {
        this.showSeats = showSeats;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}
