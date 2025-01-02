package com.example.BookMyShow.dtos.screenDtos;

public class ScreenRequestDto {
    private String screenName;
    private int theatreId;

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public void setTheatreId(int theatreId) {
        this.theatreId = theatreId;
    }
}