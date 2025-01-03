package com.example.BookMyShow.dtos.showseat;

public class ShowSeatRequestDto {
    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    private int seatId;
    private int showId;
}
