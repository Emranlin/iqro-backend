package com.example.iqro.db.dto.response;

import lombok.Builder;

@Builder
public record SurahResponse(
        Long id,
        String arabicName,
        String cyrillicName,
        String audio,
        String surah,
        String meaning,
        String transcription
) {
}
