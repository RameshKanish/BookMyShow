package com.example.BookMyShow.controller;


import com.example.BookMyShow.dtos.ResponseStatus;
import com.example.BookMyShow.dtos.signInDtos.SignInRequestDto;
import com.example.BookMyShow.dtos.signUpDtos.SignUpRequestDto;
import com.example.BookMyShow.dtos.signUpDtos.SignUpResponseDto;
import com.example.BookMyShow.exceptions.UserFoundException;
import com.example.BookMyShow.models.User;
import com.example.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/signUp")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody  SignUpRequestDto signUpRequestDto) throws UserFoundException {
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        User user = null;
        try{
            user = this.userService.signUp(signUpRequestDto.getName() , signUpRequestDto.getEmail(), signUpRequestDto.getPassword());
            signUpResponseDto.setUserId(user.getId());
            signUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return new ResponseEntity<>(signUpResponseDto, HttpStatus.OK);
        }catch (Exception e){
            signUpResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            return new ResponseEntity<>(signUpResponseDto, HttpStatus.NOT_ACCEPTABLE);
        }
    }


    @PostMapping("/signIn")
    public ResponseEntity<SignUpResponseDto> signIn(@RequestBody  SignInRequestDto signInRequestDto){
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        User user = null;
        try {
            user = this.userService.signIn(signInRequestDto.getEmail() , signInRequestDto.getPassword());
            signUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return new ResponseEntity<>(signUpResponseDto , HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(signUpResponseDto , HttpStatus.NOT_ACCEPTABLE);
        }
    }
}