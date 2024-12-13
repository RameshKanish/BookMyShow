package com.example.BookMyShow.dtos.ticketsDtos;

import java.util.List;

public class TicketDto {
    private List<Integer> showSeatIds ;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<Integer> getShowSeatIds() {
        return showSeatIds;
    }

    public void setShowSeatIds(List<Integer> showSeatIds) {
        this.showSeatIds = showSeatIds;
    }
}
