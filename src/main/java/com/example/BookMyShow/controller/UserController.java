package com.example.BookMyShow.controller;


import com.example.BookMyShow.dtos.ResponseStatus;
import com.example.BookMyShow.dtos.signInDtos.SignInRequestDto;
import com.example.BookMyShow.dtos.signUpDtos.SignUpRequestDto;
import com.example.BookMyShow.dtos.signUpDtos.SignUpResponseDto;
import com.example.BookMyShow.dtos.updateDto.UpdateRequestDto;
import com.example.BookMyShow.exceptions.UserFoundException;
import com.example.BookMyShow.exceptions.UserNotFoundException;
import com.example.BookMyShow.models.User;
import com.example.BookMyShow.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<Object> signUp(@RequestBody  SignUpRequestDto signUpRequestDto) throws UserFoundException {
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        User user = null;
        try{
            user = this.userService.signUp(signUpRequestDto.getName() , signUpRequestDto.getEmail(), signUpRequestDto.getPassword());
            signUpResponseDto.setUserId(user.getId());
            signUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            return new ResponseEntity<>(signUpResponseDto, HttpStatus.OK);
        }catch (UserFoundException e){
            signUpResponseDto.setResponseStatus(ResponseStatus.FAILURE);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/signIn")
    public ResponseEntity<Object> signIn(@RequestBody  SignInRequestDto signInRequestDto){
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();
        User user = null;
        try {
            user = this.userService.signIn(signInRequestDto.getEmail() , signInRequestDto.getPassword());
            signUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
            signUpResponseDto.setUserId(user.getId());
            return new ResponseEntity<>(signUpResponseDto , HttpStatus.ACCEPTED);
        } catch (UserNotFoundException | UserFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getOneUser(@PathVariable int userId) throws UserNotFoundException {
        try {
            User user = userService.getOneUser(userId);
            return new ResponseEntity<>(user , HttpStatus.FOUND);
        }
        catch (UserNotFoundException err){
            return new ResponseEntity<>(err.getMessage() , HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/updateUser")
    public ResponseEntity<Object> updateUser(@RequestBody UpdateRequestDto updateRequestDto)throws UserNotFoundException{
        try{
            User user = userService.update(updateRequestDto.getUserId() , updateRequestDto.getName(), updateRequestDto.getEmail(), updateRequestDto.getPassword());
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (UserNotFoundException err){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> user = userService.getAllUsers();
        return new ResponseEntity<>(user , HttpStatus.OK);
    }
}