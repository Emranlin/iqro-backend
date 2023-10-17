package com.example.iqro.db.dto.response;

import lombok.Builder;

import javax.management.relation.Role;
@Builder
public record AuthenticationResponse(
        String email,
        Role role,
        String token,
        String message
) {
}
