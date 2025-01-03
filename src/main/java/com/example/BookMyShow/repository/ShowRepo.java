package com.example.BookMyShow.repository;

import com.example.BookMyShow.models.Show;
import com.example.BookMyShow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepo extends JpaRepository<Show, Integer> { }