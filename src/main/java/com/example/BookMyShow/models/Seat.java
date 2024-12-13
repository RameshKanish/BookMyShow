package com.example.BookMyShow.models;

import jakarta.persistence.*;

@Entity(name = "seat")

public class Seat extends BaseModel{
    private String name;
    private int rowNum ;
    private int colNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRowNum() {
        return rowNum;
    }

    public void setRowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public int getColNum() {
        return colNum;
    }

    public void setColNum(int colNum) {
        this.colNum = colNum;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    @ManyToOne
    @JoinColumn(name = "screen_id" , nullable = false)
    private Screen screen;

    @Enumerated(value = EnumType.ORDINAL)
    private SeatType seatType;
}
