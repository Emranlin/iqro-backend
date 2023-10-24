package com.example.iqro.db.dto.request;

import com.example.iqro.validations.NameValid;
import com.example.iqro.validations.PasswordValid;
import com.example.iqro.validations.PhoneNumberValid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public record UserRegisterRequest(
        @NotBlank(message = "Необходимо указать имя и фамилию.")
        @NameValid(message = "Имя и фамилия должно содержать от 2 до 40 символов.")
        String fullName,
        @NotBlank(message = "Номер телефона не должен быть пустым")
        @PhoneNumberValid(message = "Номер телефона должен начинаться с +996, состоять из 13 символов и должен быть действительным!")
        String phoneNumber,
        @NotBlank(message = "Почта не должна быть пустой")
        @Email(message = "Напишите действительный адрес электронной почты!")
        String email,
        @NotBlank(message = "Пароль не должен быть пустым")
        @PasswordValid(message = "Длина пароля должна быть более 6 символов и содержать как минимум одну заглавную букву!")
        String password
) {
}
