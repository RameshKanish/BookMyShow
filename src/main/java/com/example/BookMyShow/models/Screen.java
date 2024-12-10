package com.example.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Screen extends BaseModel{
    private String name;

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

    @OneToMany(mappedBy = "screen" , orphanRemoval = true)
    private List<Seat> seats;

    @Enumerated(value = EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
