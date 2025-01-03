package com.example.BookMyShow.service.user;

import com.example.BookMyShow.exceptions.UserFoundException;
import com.example.BookMyShow.exceptions.UserNotFoundException;
import com.example.BookMyShow.models.User;

import java.util.List;

public interface UserService {
    public User signUp(String name , String email , String password) throws UserFoundException;
    public User signIn(String email , String password) throws UserFoundException, UserNotFoundException;
    public User getOneUser(int userId) throws  UserNotFoundException;
    public User update(int userId , String name , String email , String password) throws UserNotFoundException;
    public List<User> getAllUsers();
}