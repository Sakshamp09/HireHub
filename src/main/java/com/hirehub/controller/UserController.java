package com.hirehub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hirehub.dto.RegisterRequest;
import com.hirehub.dto.RegisterResponse;
import com.hirehub.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public RegisterResponse registerUser(@RequestBody RegisterRequest request) {

        return userService.registerUser(request);

    }
}