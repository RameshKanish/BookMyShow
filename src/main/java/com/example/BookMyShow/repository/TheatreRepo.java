package com.example.BookMyShow.repository;

import com.example.BookMyShow.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre , Integer> { }
