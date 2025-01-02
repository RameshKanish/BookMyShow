package com.example.BookMyShow.service.screen;

import com.example.BookMyShow.exceptions.TheatreNotFoundException;
import com.example.BookMyShow.models.Screen;

import java.util.List;

public interface ScreenService {
    public Screen createScreen(String screenName , int screenId) throws TheatreNotFoundException;
    public List<Screen> getAllScreen();
}
