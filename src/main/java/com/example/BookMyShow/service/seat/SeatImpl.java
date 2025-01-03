package com.example.BookMyShow.service.seat;


import com.example.BookMyShow.exceptions.ScreenNotFoundException;
import com.example.BookMyShow.models.Screen;
import com.example.BookMyShow.models.Seat;
import com.example.BookMyShow.models.SeatType;
import com.example.BookMyShow.repository.ScreenRepo;
import com.example.BookMyShow.repository.SeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class SeatImpl implements SeatService{

    @Autowired
    private ScreenRepo screenRepo;

    @Autowired
    private SeatRepo seatRepo;

    @Override
    public Seat createSeat(String name, int rowNum, int colNum, SeatType seatType, int screenId ) throws ScreenNotFoundException {

        Optional<Screen> screen = screenRepo.findById(screenId);

        if(screen.isEmpty()){
            throw new ScreenNotFoundException("Screen Not Found");
        }


        Seat seat = new Seat();

        seat.setName(name);
        seat.setRowNum(rowNum);
        seat.setColNum(colNum);
        seat.setScreen(screen.orElse(null));

        return seatRepo.save(seat);
    }
}
