package com.example.BookMyShow.service;

import com.example.BookMyShow.exceptions.UserFoundException;
import com.example.BookMyShow.exceptions.UserNotFoundException;
import com.example.BookMyShow.models.User;
import com.example.BookMyShow.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public User signUp(String name, String email, String password) throws UserFoundException {


        System.out.println("name" + name);

        System.out.println("name" + email);

        System.out.println("name" + password);

        if(userRepo.findByEmail(email) != null){
            throw new UserFoundException("User is already present in this email.");
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = bCryptPasswordEncoder.encode(password);

        User userObj = new User();
        userObj.setName(name);
        userObj.setEmail(email);
        userObj.setPassword(hashedPassword);

        return userRepo.save(userObj);
    }

    @Override
    public User signIn(String email, String password) throws UserFoundException, UserNotFoundException {
        User user = userRepo.findByEmail(email);

        System.out.println("user......." + user);

        if(user == null){
            throw new UserFoundException("Check your email.");
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        boolean bool = bCryptPasswordEncoder.matches(password , user.getPassword());


        if(!bool){
            throw new UserNotFoundException("Password is Incorrect");
        }
        return user;
    }
}