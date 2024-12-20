package com.example.BookMyShow.service.movie;

import com.example.BookMyShow.exceptions.MovieNotFoundException;
import com.example.BookMyShow.models.Genre;
import com.example.BookMyShow.models.Movie;
import com.example.BookMyShow.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepo movieRepo;

    @Override
    public Movie createMovie(String name, Genre genre) {
        Movie movie = new Movie();

        movie.setGenre(genre);
        movie.setName(name);

        return movieRepo.save(movie);
    }

    public List<Movie> getAllMovies(){
        return movieRepo.findAllIsDeletedFalse();
    }

    @Override
    public Movie getOneMovie(int movieId) throws MovieNotFoundException {
        return movieRepo.findByIdIsDeletedFalse(movieId).orElseThrow(() -> new MovieNotFoundException("Movie Not found"));
    }

    @Override
    public boolean deleteMovie(int movieId) throws MovieNotFoundException {
        Movie movie = movieRepo.findByIdIsDeletedFalse(movieId).orElseThrow(() -> new MovieNotFoundException("Movie is Not Found"));

        movie.setDeleted(true);
        movieRepo.save(movie);

        return true;
    }
}