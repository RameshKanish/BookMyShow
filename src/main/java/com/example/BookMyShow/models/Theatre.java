package com.example.BookMyShow.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class Theatre extends BaseModel{
    private String name;
    private String address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id" , nullable = false)
    @JsonBackReference
    private City city;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Screen> screens;


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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

}