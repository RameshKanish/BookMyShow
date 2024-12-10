package com.example.BookMyShow.service;

import com.example.BookMyShow.exceptions.UserFoundException;
import com.example.BookMyShow.models.User;

public interface UserService {
    public User signUp(String name , String email , String password) throws UserFoundException;
}
