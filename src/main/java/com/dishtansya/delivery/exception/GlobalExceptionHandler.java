package com.dishtansya.delivery.exception;

import com.dishtansya.delivery.dto.OrderResponse;
import com.dishtansya.delivery.dto.RegistrationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailAlreadyTakenException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RegistrationResponse handleEmailAlreadyTaken(EmailAlreadyTakenException ex) {
        return new RegistrationResponse(ex.getMessage());
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public RegistrationResponse handleInvalidCredentials(InvalidCredentialsException ex) {
        return new RegistrationResponse(ex.getMessage());
    }

    @ExceptionHandler(InsufficientStockException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public OrderResponse handleInsufficientStock(InsufficientStockException ex) {
        return new OrderResponse(ex.getMessage());
    }
}