package com.dishtansya.delivery.service.impl;

import com.dishtansya.delivery.dto.RegistrationRequest;
import com.dishtansya.delivery.dto.RegistrationResponse;
import com.dishtansya.delivery.entity.Users;
import com.dishtansya.delivery.exception.EmailAlreadyTakenException;
import com.dishtansya.delivery.repository.RegistrationRepository;
import com.dishtansya.delivery.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Override
    public RegistrationResponse createRegistration(RegistrationRequest registrationRequest) {

        if (registrationRepository.existsByEmail(registrationRequest.getEmail())) {
            throw new EmailAlreadyTakenException("Email already taken");
        }

        Users user = new Users();
        user.setEmail(registrationRequest.getEmail());
        user.setPassword(registrationRequest.getPassword());

        registrationRepository.save(user);

        return new RegistrationResponse("User successfully registered");
    }
}