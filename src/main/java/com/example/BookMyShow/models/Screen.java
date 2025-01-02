package com.example.BookMyShow.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Screen extends BaseModel{
    private String name;

    @Enumerated(value = EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    @OneToMany(mappedBy = "screen" , orphanRemoval = true)
    @JsonManagedReference
    private List<Seat> seats;

    @ManyToOne()
    @JoinColumn(name = "theatre_id" , nullable = false)
    @JsonBackReference
    private Theatre theatre;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }


    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }


    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }
}