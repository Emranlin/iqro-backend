package com.example.iqro.db.dto.response;

public record DuaResponse(
        Long duaId,
        String duaName,
        String arabicText,
        String transcription,
        String meaning,
        String audio
) {
}
