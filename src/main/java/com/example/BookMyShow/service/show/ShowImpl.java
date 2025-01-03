package com.example.BookMyShow.service.show;

import com.example.BookMyShow.exceptions.MovieNotFoundException;
import com.example.BookMyShow.exceptions.ScreenNotFoundException;
import com.example.BookMyShow.models.Movie;
import com.example.BookMyShow.models.Screen;
import com.example.BookMyShow.models.Show;
import com.example.BookMyShow.repository.MovieRepo;
import com.example.BookMyShow.repository.ScreenRepo;
import com.example.BookMyShow.repository.ShowRepo;
import com.example.BookMyShow.repository.ShowSeatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ShowImpl implements ShowService{

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private ScreenRepo screenRepo;

    @Autowired
    private ShowRepo showRepo;

    @Autowired
    private ShowSeatRepo showSeatRepo;

    @Override
    public Show createShow(Date startTime, int movieId, int screenId) throws MovieNotFoundException, ScreenNotFoundException {

        Optional<Movie> movie = movieRepo.findById(movieId);
        if(movie.isEmpty()){
            throw new MovieNotFoundException("Movie Not Found");
        }

        Optional<Screen> screen = screenRepo.findById(screenId);
        if(screen.isEmpty()){
            throw new ScreenNotFoundException("Screen Not Found");
        }

        Show show = new Show();

        show.setScreen(screen.orElse(null));
        show.setMovie(movie.orElse(null));
        show.setStartTime(startTime);


        Show showData = showRepo.save(show);

        return  showData;
    }
}