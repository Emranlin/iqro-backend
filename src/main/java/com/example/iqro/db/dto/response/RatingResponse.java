package com.example.iqro.db.dto.response;

import lombok.Builder;

@Builder
public record RatingResponse(
        Long id,
        String avatar,
        String name,
        Long point,
        boolean itsMe
) {
}
