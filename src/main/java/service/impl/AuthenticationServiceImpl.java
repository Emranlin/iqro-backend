package service.impl;

import com.example.iqro.db.dto.request.AuthenticateRequest;
import com.example.iqro.db.dto.request.UserRegisterRequest;
import com.example.iqro.db.dto.response.AuthenticationResponse;
import com.example.iqro.db.model.User;
import com.example.iqro.db.model.enums.Role;
import com.example.iqro.db.model.exceptions.AlreadyExistException;
import com.example.iqro.db.model.exceptions.BadRequestException;
import config.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import service.AuthenticationService;

import java.util.Random;

@Service
@RequiredArgsConstructor

public class AuthenticationServiceImpl implements AuthenticationService {
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

        User user = User.builder()
                .email(request.email())
                .phoneNumber(request.phoneNumber())
                .password(passwordEncoder.encode(request.password()))
                .confirmationCode(confirmationCode)
                .role(Role.USER)
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
                        String.format("Пользователь с адресом электронной почты %s не существует", request.email())
                ));

        if (!passwordEncoder.matches(request.password(), user.getPassword())) {
            throw new BadRequestException("Пароль не подходит");
        }

        if (!user.isEmailConfirmed()) {
            return AuthenticationResponse.builder()
                    .message(String.format("Пользователь с адресом электронной почты %s следует подтвердить учетную запись", request.email()))
                    .build();
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        String token = jwtService.generateToken(user);

        Role userRole = user.getRole();

        return AuthenticationResponse.builder()
                .email(user.getEmail())
                .role(userRole)
                .token(token)
                .build();
    }
}




