package com.dishtansya.delivery.service;

import com.dishtansya.delivery.dto.RegistrationRequest;
import com.dishtansya.delivery.dto.RegistrationResponse;


public interface RegistrationService {
    RegistrationResponse createRegistration(RegistrationRequest registrationRequest);
}
