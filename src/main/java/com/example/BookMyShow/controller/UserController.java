package com.example.BookMyShow.controller;


import com.example.BookMyShow.dtos.ResponseStatus;
import com.example.BookMyShow.dtos.SignInRequestDto;
import com.example.BookMyShow.dtos.SignUpRequestDto;
import com.example.BookMyShow.dtos.SignUpResponseDto;
import com.example.BookMyShow.exceptions.UserFoundException;
import com.example.BookMyShow.models.User;
import com.example.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    public SignUpResponseDto signUp(SignUpRequestDto signUpRequestDto) throws UserFoundException {
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        try{
            User user = this.userService.signUp(signUpRequestDto.getName() , signUpRequestDto.getEmail(), signUpRequestDto.getPassword());
            signUpResponseDto.setUserId(user.getId());
            signUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            signUpResponseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return signUpResponseDto;
    }

    public SignUpResponseDto signIn(SignInRequestDto signInRequestDto){
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        try {
            User user = this.userService.signIn(signInRequestDto.getEmail() , signInRequestDto.getPassword());
            signUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return signUpResponseDto;
    }
}