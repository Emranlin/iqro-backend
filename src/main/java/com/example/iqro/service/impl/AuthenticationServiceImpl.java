package com.example.iqro.service.impl;

import com.example.iqro.config.jwt.JwtService;
import com.example.iqro.db.dto.request.AuthenticateRequest;
import com.example.iqro.db.dto.request.UserRegisterRequest;
import com.example.iqro.db.dto.response.auth.AuthenticationResponse;
import com.example.iqro.db.dto.response.auth.RegistrationResponse;
import com.example.iqro.db.enums.Role;
import com.example.iqro.db.exceptions.*;
import com.example.iqro.db.model.User;
import com.example.iqro.db.model.UserInfo;
import com.example.iqro.repository.UserRepository;
import com.example.iqro.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor

public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public RegistrationResponse userRegister(UserRegisterRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new AlreadyExistException(String.format("Пользоватль с таким адресом электронной почты %s уже существует", request.email()));
        }
        String split = request.email().split("@")[0];
        if (split.equals(request.password())) {
            throw new BadRequestException("Пароль не соответствует требованиям безопасности");
        }

        int confirmationCode = generateConfirmationCode();
        UserInfo userInfo = UserInfo.builder()
                .name(request.fullName())
                .phoneNumber(request.phoneNumber())
                .registerDate(LocalDate.now())
                .confirmationCode(confirmationCode)
                .emailConfirmed(false)
                .expirationTime(LocalDateTime.now().plusHours(1L))
                .registerDate(LocalDate.now())
                .build();

        User user = User.builder()
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.USER)
                .userInfo(userInfo)
                .build();
        userRepository.save(user);


        return RegistrationResponse.builder()
                .message("Теперь вы должны пройти проверку")
                .build();
    }

    private int generateConfirmationCode() {
        Random random = new Random();

        return random.nextInt(1000, 9999);
    }


    @Override
    public AuthenticationResponse authenticate(AuthenticateRequest request) {
        User user = userRepository.findByEmail(request.email())
                .orElseThrow(() -> new BadCredentialException(
                        String.format("Пользователь с такой электронной почты %s не существует", request.email())
                ));
        UserInfo userInfo = user.getUserInfo();

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new BadCredentialException("Пароль не подходит");
        }

//        if (!userInfo.isEmailConfirmed()) {
//            throw new EmailNotConfirmedException(String.format("Подтвердите вашу электронную почту: %s", request.email()));
//        }


        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        String token = jwtService.generateToken(user);


        return AuthenticationResponse.builder()
                .email(user.getEmail())
                .role(user.getRole())
                .token(token)
                .build();
    }

    @Override
    public RegistrationResponse confirmRegistration(String email, int code) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Пользователь с таким адресом электронной почты не найден"));
        UserInfo userInfo = user.getUserInfo();
        if (userInfo.isEmailConfirmed()) {
            return RegistrationResponse.builder()
                    .message("Почта уже подтверждена.").build();
        }

        int storedConfirmationCode = userInfo.getConfirmationCode();

        if (code == storedConfirmationCode && userInfo.getExpirationTime().isAfter(LocalDateTime.now())) {
            userInfo.setEmailConfirmed(true);
            userRepository.save(user);
            return RegistrationResponse.builder().message("Подтверждение почты прошло успешно.").build();
        } else {
            throw new BadRequestException("Неверный код подтверждения или истек срок его действия");
        }
    }


}




