package com.dishtansya.delivery.controller;

import com.dishtansya.delivery.dto.LoginRequest;
import com.dishtansya.delivery.dto.LoginResponse;
import com.dishtansya.delivery.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final LoginService loginService;

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        return loginService.login(loginRequest);
    }
}