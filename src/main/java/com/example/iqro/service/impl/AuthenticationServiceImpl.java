package com.example.iqro.service.impl;

import com.example.iqro.config.jwt.JwtService;
import com.example.iqro.db.dto.request.AdminRegisterRequest;
import com.example.iqro.db.dto.request.AuthenticateRequest;
import com.example.iqro.db.dto.request.UserRegisterRequest;
import com.example.iqro.db.dto.response.AuthenticationResponse;
import com.example.iqro.db.enums.Role;
import com.example.iqro.db.exceptions.AlreadyExistException;
import com.example.iqro.db.exceptions.BadCredentialException;
import com.example.iqro.db.exceptions.BadRequestException;
import com.example.iqro.db.exceptions.NotFoundException;
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
    private final static LocalDateTime expirationTime = LocalDateTime.now().plusHours(1);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse userRegister(UserRegisterRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new AlreadyExistException(String.format("Пользоватль с таким адресом электронной почты %s уже существует", request.email()));
        }
        String split = request.email().split("@")[0];
        if (split.equals(request.password())) {
            throw new BadRequestException("Пароль не соответствует требованиям безопасности");
        }

        int confirmationCode = generateConfirmationCode();
        UserInfo userInfo = UserInfo.builder()
                .phoneNumber(request.phoneNumber())
                .build();

        User user = User.builder()
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .userInfo(userInfo)
                .confirmationCode(confirmationCode)
                .role(Role.USER)
                .emailConfirmed(false)
                .registerDate(LocalDate.now())
                .build();
        userRepository.save(user);


        return AuthenticationResponse.builder()
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

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new BadRequestException("Пароль не подходит");
        }

        if (!user.isEmailConfirmed()) {
            return AuthenticationResponse.builder()
                    .message(String.format("Пользователь с такой электронной почты %s следует подтвердить учетную запись", request.email()))
                    .build();
        }

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
    public AuthenticationResponse AdminRegister(AdminRegisterRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new AlreadyExistException(String.format("Пользоватль с таким электронной почты %s уже существует", request.email()));
        }
        String split = request.email().split("@")[0];
        if (split.equals(request.password())) {
            throw new BadRequestException("Пароль не соответствует требованиям безопасности");
        }

        User user = User.builder()
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .role(Role.ADMIN)
                .registerDate(LocalDate.now())
                .build();

        userRepository.save(user);
        String token = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .email(user.getEmail())
                .role(user.getRole())
                .token(token)
                .message("Добро пожаловать в админ панель")
                .build();
    }

    @Override
    public AuthenticationResponse confirmRegistration(String email, int code) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Пользователь с таким адресом электронной почты не найден"));

        if (user.isEmailConfirmed()) {
            return AuthenticationResponse.builder().message("Почта уже подтверждена.").build();
        }

        int storedConfirmationCode = user.getConfirmationCode();

        if (code == storedConfirmationCode && expirationTime.isAfter(LocalDateTime.now())) {
            user.setEmailConfirmed(true);
            userRepository.save(user);
            return AuthenticationResponse.builder().message("Подтверждение почты прошло успешно.").build();
        } else {
            throw new BadRequestException("Неверный код подтверждения или истек срок его действия");
        }
    }


}




