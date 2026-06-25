package com.dishtansya.delivery.controller;

import com.dishtansya.delivery.dto.RegistrationRequest;
import com.dishtansya.delivery.dto.RegistrationResponse;
import com.dishtansya.delivery.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegistrationResponse createRegistration(@RequestBody RegistrationRequest userRequest) {
        return registrationService.createRegistration(userRequest);
    }
}
