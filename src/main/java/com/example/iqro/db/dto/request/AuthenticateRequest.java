package com.example.iqro.db.dto.request;

import javax.validation.constraints.NotBlank;

public record AuthenticateRequest(
        @NotBlank(message = "Электронная почта не должна быть пустой!")
        String email,
        @NotBlank(message = "Пароль не должен быть пустым!")
        String password
) {
}
