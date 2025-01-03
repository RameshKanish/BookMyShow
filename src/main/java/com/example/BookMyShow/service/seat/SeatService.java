package com.example.BookMyShow.service.seat;

import com.example.BookMyShow.exceptions.ScreenNotFoundException;
import com.example.BookMyShow.models.Seat;
import com.example.BookMyShow.models.SeatType;

public interface SeatService {

    public Seat createSeat(String name , int rowNum , int colNum , SeatType seatType , int screenId) throws ScreenNotFoundException;
}
