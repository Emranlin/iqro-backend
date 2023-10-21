package com.example.iqro.service;

import com.example.iqro.db.dto.request.AdminRegisterRequest;
import com.example.iqro.db.dto.request.AuthenticateRequest;
import com.example.iqro.db.dto.request.UserRegisterRequest;
import com.example.iqro.db.dto.response.AuthenticationResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    AuthenticationResponse userRegister(UserRegisterRequest request);

    AuthenticationResponse authenticate(AuthenticateRequest request);

    AuthenticationResponse AdminRegister(AdminRegisterRequest request);

    AuthenticationResponse confirmRegistration(String email, int code);
}
