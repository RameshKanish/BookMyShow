package com.example.BookMyShow.service.showseat;


import com.example.BookMyShow.exceptions.SeatNotFoundException;
import com.example.BookMyShow.exceptions.ShowNotFoundException;
import com.example.BookMyShow.models.ShowSeat;
import org.springframework.stereotype.Service;

public interface ShowSeatService {
    public ShowSeat createShowSeat(int seatId , int showId) throws ShowNotFoundException, SeatNotFoundException;
}