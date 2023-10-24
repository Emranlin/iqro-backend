package com.example.iqro.service;

import com.example.iqro.db.dto.request.AuthenticateRequest;
import com.example.iqro.db.dto.request.UserRegisterRequest;
import com.example.iqro.db.dto.response.AuthenticationResponse;
import com.example.iqro.db.dto.response.RegistrationResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    RegistrationResponse userRegister(UserRegisterRequest request);

    AuthenticationResponse authenticate(AuthenticateRequest request);

    RegistrationResponse confirmRegistration(String email, int code);
}
