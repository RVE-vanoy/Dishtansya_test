package com.dishtansya.delivery.service.impl;

import com.dishtansya.delivery.dto.LoginRequest;
import com.dishtansya.delivery.dto.LoginResponse;
import com.dishtansya.delivery.entity.Users;
import com.dishtansya.delivery.exception.InvalidCredentialsException;
import com.dishtansya.delivery.repository.RegistrationRepository;
import com.dishtansya.delivery.service.JwtService;
import com.dishtansya.delivery.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final RegistrationRepository registrationRepository;
    private final JwtService jwtService;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {

        Users user = registrationRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new InvalidCredentialsException("Invalid credentials"));

        if (!user.getPassword().equals(loginRequest.getPassword())) {
            throw new InvalidCredentialsException("Invalid credentials");
        }

        String token = jwtService.generateToken(user.getEmail());

        return new LoginResponse(token);
    }
}