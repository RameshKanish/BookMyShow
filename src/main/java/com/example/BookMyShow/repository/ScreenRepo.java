package com.example.BookMyShow.repository;

import com.example.BookMyShow.models.City;
import com.example.BookMyShow.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenRepo extends JpaRepository<Screen, Integer> { }