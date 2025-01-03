package com.example.BookMyShow.dtos.showDtos;

import java.util.Date;

public class ShowRequestDto {
        private Date startTime;


        private int movieId;
        private int screenId;


    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

}