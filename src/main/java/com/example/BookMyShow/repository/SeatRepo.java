package com.example.BookMyShow.repository;

import com.example.BookMyShow.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepo extends JpaRepository<Seat , Integer> { }
