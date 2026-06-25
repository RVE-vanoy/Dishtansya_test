package com.dishtansya.delivery.service;

import com.dishtansya.delivery.dto.LoginRequest;
import com.dishtansya.delivery.dto.LoginResponse;

public interface LoginService {

    LoginResponse login(LoginRequest loginRequest);
}