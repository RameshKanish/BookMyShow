package com.example.BookMyShow.repository;

import com.example.BookMyShow.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepo extends JpaRepository<Seat , Integer> { }
