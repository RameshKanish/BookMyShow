package com.example.BookMyShow.dtos.signUpDtos;


import com.example.BookMyShow.dtos.ResponseStatus;

public class SignUpResponseDto {
    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private ResponseStatus responseStatus;
    private int userId;
}
