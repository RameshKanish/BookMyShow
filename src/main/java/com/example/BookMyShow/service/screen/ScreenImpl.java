package com.example.BookMyShow.service.screen;

import com.example.BookMyShow.exceptions.TheatreNotFoundException;
import com.example.BookMyShow.models.Screen;
import com.example.BookMyShow.models.Theatre;
import com.example.BookMyShow.repository.ScreenRepo;
import com.example.BookMyShow.repository.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScreenImpl implements ScreenService{

    @Autowired
    private ScreenRepo screenRepo;

    @Autowired
    private TheatreRepo theatreRepo;

    @Override
    public Screen createScreen(String screenName, int theatreId) throws TheatreNotFoundException {

        Optional<Theatre> theatre = theatreRepo.findById(theatreId);

        if (theatre.isEmpty()){
            throw new TheatreNotFoundException("Theatre Not Found");
        }

        Screen screen = new Screen();

        screen.setName(screenName);
        screen.setTheatre(theatre.orElse(null));

        return screenRepo.save(screen);
    }

    @Override
    public List<Screen> getAllScreen() {
        return screenRepo.findAll();
    }
}