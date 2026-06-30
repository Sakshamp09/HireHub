package com.hirehub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hirehub.dto.RegisterRequest;
import com.hirehub.dto.RegisterResponse;
import com.hirehub.entity.User;
import com.hirehub.enums.AccountStatus;
import com.hirehub.enums.Role;
import com.hirehub.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterResponse registerUser(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        if (userRepository.existsByPhone(request.getPhone())) {
            throw new RuntimeException("Phone number already exists");
        }

        User user = new User();

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());

        user.setRole(Role.valueOf(request.getRole().toUpperCase()));
        user.setAccountStatus(AccountStatus.ACTIVE);

        User savedUser = userRepository.save(user);

        return new RegisterResponse(
                savedUser.getId(),
                "User Registered Successfully"
        );
    }
}