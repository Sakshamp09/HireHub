package com.hirehub.service;

import com.hirehub.dto.LoginRequest;
import com.hirehub.dto.LoginResponse;
import com.hirehub.dto.RegisterRequest;
import com.hirehub.dto.RegisterResponse;

public interface UserService {

    RegisterResponse registerUser(RegisterRequest request);

    LoginResponse loginUser(LoginRequest request);

}