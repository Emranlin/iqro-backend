package com.example.iqro.api;

import com.example.iqro.db.dto.request.AuthenticateRequest;
import com.example.iqro.db.dto.request.UserRegisterRequest;
import com.example.iqro.db.dto.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import service.AuthenticationService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationApi {
    private final AuthenticationService authenticationService;


    @PostMapping("/sign-up/buyer")
    public AuthenticationResponse signUpUser(@RequestBody  @Valid UserRegisterRequest request) {
        return authenticationService.userRegister(request);
    }

    @PostMapping("/sign-in")
    public AuthenticationResponse signIn(@RequestBody @Valid AuthenticateRequest request) {
        return authenticationService.authenticate(request);
    }

}
