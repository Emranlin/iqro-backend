package com.example.iqro.db.dto.response.auth;

import com.example.iqro.db.enums.Role;
import lombok.Builder;

@Builder
public record AuthenticationResponse(
        String email,
        Role role,
        String token
) {
}
