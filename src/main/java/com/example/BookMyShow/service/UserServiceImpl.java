package com.example.BookMyShow.service;

import com.example.BookMyShow.exceptions.UserFoundException;
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
}
