package com.hirehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hirehub.dto.RegisterRequest;
import com.hirehub.dto.RegisterResponse;
import com.hirehub.service.UserService;

import com.hirehub.dto.LoginRequest;
import com.hirehub.dto.LoginResponse;
import jakarta.validation.Valid;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public RegisterResponse registerUser(@Valid @RequestBody RegisterRequest request) {

        return userService.registerUser(request);

    }
    
    @PostMapping("/login")
    public LoginResponse loginUser(@Valid @RequestBody LoginRequest request) {

        return userService.loginUser(request);
    }
}