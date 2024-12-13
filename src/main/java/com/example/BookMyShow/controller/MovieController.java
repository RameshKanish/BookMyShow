package com.example.BookMyShow.controller;


import com.example.BookMyShow.dtos.MovieDtos.MovieRequestDto;
import com.example.BookMyShow.dtos.MovieDtos.MovieResponseDto;
import com.example.BookMyShow.dtos.ResponseStatus;
import com.example.BookMyShow.models.Movie;
import com.example.BookMyShow.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired private MovieService movieService;

    /*
     * Author		      : Ramesh R S
     * Created On		  : 13-12-2024
     * Modified on        : 13-12-2024
     * Function           : createMovie
     *  Method createMovie is used to create movie.
     * @param {} movieRequestDto which is used to create a movie.
     */

    @PostMapping("create")
    public ResponseEntity<MovieResponseDto> createMovie(@RequestBody MovieRequestDto movieRequestDto){
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        try {
            Movie movie = movieService.createMovie(movieRequestDto.getMovieName() , movieRequestDto.getGenre());
            movieResponseDto.setMovieId(movie.getId());
            movieResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return new ResponseEntity<>(movieResponseDto , HttpStatus.ACCEPTED);
        }catch (Exception e){
            movieResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return new ResponseEntity<>(movieResponseDto , HttpStatus.NOT_ACCEPTABLE);
    }

    /*
     * Author		      : Ramesh R S
     * Created On		  : 13-12-2024
     * Modified on        : 13-12-2024
     * Function           : getAllMovie
     *  Method createMovie is used to getAll movie.
     */

    @GetMapping("getMovies")
    public ResponseEntity<MovieResponseDto> getAllMovie(){
        MovieResponseDto movieResponseDto = new MovieResponseDto();
        try {
            List<Movie> movies = movieService.getAllMovies();
            movieResponseDto.setMovies(movies);
            movieResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return new ResponseEntity<>(movieResponseDto , HttpStatus.ACCEPTED);
        }catch (Exception e){
            movieResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return new ResponseEntity<>(movieResponseDto , HttpStatus.NOT_ACCEPTABLE);
    }
}