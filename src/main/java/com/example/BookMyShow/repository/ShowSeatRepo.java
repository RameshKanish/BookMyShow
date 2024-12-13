package com.example.BookMyShow.repository;

import com.example.BookMyShow.models.SeatStatus;
import com.example.BookMyShow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ShowSeatRepo extends JpaRepository<ShowSeat, Long> {
    List<ShowSeat> findBySeat_IdInAndSeatStatus(List<Integer> seatIds, SeatStatus seatStatus);
}