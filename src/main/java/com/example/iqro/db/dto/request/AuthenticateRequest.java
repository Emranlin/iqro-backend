package com.example.iqro.db.dto.request;

import com.example.iqro.validations.PasswordValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;



public record AuthenticateRequest(
        @NotBlank(message = "Почта не должна быть пустой")
        @Email(message = "Напишите действительный адрес электронной почты!")
        String email,
        @NotBlank(message = "Пароль не должен быть пустым")
        @PasswordValid(message = "Длина пароля должна быть более 6 символов и содержать как минимум одну заглавную букву!")
        String password
) {
}
