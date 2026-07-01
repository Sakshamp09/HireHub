package com.hirehub.dto;

public class LoginResponse {

    private Long userId;
    private String token;
    private String message;

    public LoginResponse() {
    }

    public LoginResponse(Long userId, String token, String message) {
        this.userId = userId;
        this.token = token;
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}