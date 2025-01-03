package com.example.BookMyShow.dtos.theatredtos;

import com.example.BookMyShow.models.Screen;
import com.example.BookMyShow.models.Theatre;

import java.util.List;

public class TheatreResponseDto {
    private int id;
    private String name;
    private String address;
    private int city_id;
    private List<Screen> screens;

    public TheatreResponseDto(Theatre theatre){
        this.id = theatre.getId();
        this.name = theatre.getName();
        this.address = theatre.getAddress();
        this.city_id = theatre.getCity().getId();
        this.screens = theatre.getScreens();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCity() {
        return city_id;
    }

    public void setCity(int city_id) {
        this.city_id = city_id;
    }

}
