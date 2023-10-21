package com.example.iqro.api;

import com.example.iqro.db.dto.request.AdminRegisterRequest;
import com.example.iqro.db.dto.request.AuthenticateRequest;
import com.example.iqro.db.dto.request.UserRegisterRequest;
import com.example.iqro.db.dto.response.AuthenticationResponse;
import com.example.iqro.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AuthenticationApi {
    private final AuthenticationService authenticationService;

    @Operation(summary = "Register a new user", description = "This method validates the request and creates a new user.")
    @PostMapping("/sign-up/user")
    public AuthenticationResponse signUpUser(@RequestBody @Valid UserRegisterRequest request) {
        return authenticationService.userRegister(request);
    }

    @Operation(summary = "Register a admin", description = "This method validates the request and creates admin.")
    @PostMapping("/sign-up/admin")
    public AuthenticationResponse signUpAdmin(@RequestBody @Valid AdminRegisterRequest request) {
        return authenticationService.AdminRegister(request);
    }

    @Operation(summary = "Confirm", description = "This method for confirm code checking method")
    @PostMapping("/confirm")
    AuthenticationResponse confirmRegistration(String email, int code) {
        return authenticationService.confirmRegistration(email, code);
    }

    @PostMapping("/sign-in")
    public AuthenticationResponse signIn(@RequestBody @Valid AuthenticateRequest request) {
        return authenticationService.authenticate(request);
    }

}
