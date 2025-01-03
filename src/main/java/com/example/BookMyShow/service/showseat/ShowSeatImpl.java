package com.example.BookMyShow.service.showseat;

import com.example.BookMyShow.exceptions.SeatNotFoundException;
import com.example.BookMyShow.exceptions.ShowNotFoundException;
import com.example.BookMyShow.models.Seat;
import com.example.BookMyShow.models.SeatStatus;
import com.example.BookMyShow.models.Show;
import com.example.BookMyShow.models.ShowSeat;
import com.example.BookMyShow.repository.SeatRepo;
import com.example.BookMyShow.repository.ShowRepo;
import com.example.BookMyShow.repository.ShowSeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ShowSeatImpl implements ShowSeatService{

    @Autowired
    private SeatRepo seatRepo;

    @Autowired
    private ShowRepo showRepo;

    @Autowired
    private ShowSeatRepo showSeatRepo;

    @Override
    public ShowSeat createShowSeat(int seatId, int showId) throws ShowNotFoundException, SeatNotFoundException {

        System.out.println("SeatID" + seatId);
        System.out.println("showId" + showId);

        Optional<Seat> seat = seatRepo.findById(seatId);

        if(seat.isEmpty()){
            throw new SeatNotFoundException("Seat Not Found");
        }

        Optional<Show> show = showRepo.findById(showId);

        if(show.isEmpty()){
            throw new ShowNotFoundException("Show Not Found");
        }

        ShowSeat showSeat = new ShowSeat();

        showSeat.setSeatStatus(SeatStatus.AVAILABLE);
        showSeat.setSeat(seat.orElse(null));
        showSeat.setShow(show.orElse(null));

        return showSeatRepo.save(showSeat);
    }
}
