package com.example.BookMyShow.service.show;

import com.example.BookMyShow.exceptions.MovieNotFoundException;
import com.example.BookMyShow.exceptions.ScreenNotFoundException;
import com.example.BookMyShow.models.Show;

import java.util.Date;

public interface ShowService {
    public Show createShow(Date startTime , int movieId , int screenId) throws MovieNotFoundException, ScreenNotFoundException;
}
