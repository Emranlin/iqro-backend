package com.example.iqro.db.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record UserRegisterRequest(
        @NotBlank(message = "Необходимо указать имя и фамилию.")
        String fullName,
        String phoneNumber,
        @NotBlank(message = "Почта не должна быть пустой")
        @Email(message = "Напишите действительный адрес электронной почты!")
        String email,
        @NotBlank(message = "Пароль не должен быть пустым")

        String password
) {
}
