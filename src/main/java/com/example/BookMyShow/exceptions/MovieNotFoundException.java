package com.example.BookMyShow.exceptions;

public class MovieNotFoundException extends Exception{
    public MovieNotFoundException(String message){
        super(message);
    }
}
