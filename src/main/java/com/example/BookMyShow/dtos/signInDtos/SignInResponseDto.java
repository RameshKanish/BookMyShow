package com.example.BookMyShow.dtos.signInDtos;

import com.example.BookMyShow.dtos.ResponseStatus;

public class SignInResponseDto {
    private ResponseStatus responseStatus;
    private int userId;

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
}
