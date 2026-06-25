package com.dishtansya.delivery.service.impl;

import com.dishtansya.delivery.dto.RegistrationRequest;
import com.dishtansya.delivery.dto.RegistrationResponse;
import com.dishtansya.delivery.entity.Users;
import com.dishtansya.delivery.exception.EmailAlreadyTakenException;
import com.dishtansya.delivery.repository.RegistrationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RegistrationServiceImplTest {

    @Mock
    private RegistrationRepository registrationRepository;

    @InjectMocks
    private RegistrationServiceImpl registrationService;

    @Test
    void createRegistration_shouldReturnSuccessMessage_whenEmailIsNotTaken() {
        RegistrationRequest request = new RegistrationRequest();
        request.setEmail("backend@multisyscorp.com");
        request.setPassword("test123");

        when(registrationRepository.existsByEmail(request.getEmail())).thenReturn(false);

        RegistrationResponse response = registrationService.createRegistration(request);

        assertEquals("User successfully registered", response.getMessage());

        verify(registrationRepository, times(1)).existsByEmail(request.getEmail());
        verify(registrationRepository, times(1)).save(any(Users.class));
    }

    @Test
    void createRegistration_shouldThrowException_whenEmailAlreadyTaken() {
        RegistrationRequest request = new RegistrationRequest();
        request.setEmail("backend@multisyscorp.com");
        request.setPassword("test123");

        when(registrationRepository.existsByEmail(request.getEmail())).thenReturn(true);

        EmailAlreadyTakenException exception = assertThrows(
                EmailAlreadyTakenException.class,
                () -> registrationService.createRegistration(request)
        );

        assertEquals("Email already taken", exception.getMessage());

        verify(registrationRepository, times(1)).existsByEmail(request.getEmail());
        verify(registrationRepository, never()).save(any(Users.class));
    }
}