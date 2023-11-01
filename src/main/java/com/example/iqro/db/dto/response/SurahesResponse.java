package com.example.iqro.db.dto.response;

import lombok.Builder;

@Builder
public record SurahesResponse(
        Long id,
        String arabicName,
        String cyrillicName,
        String audio
) {
}
