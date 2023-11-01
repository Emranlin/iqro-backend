package com.example.iqro.db.dto.response;

import java.time.LocalDate;

public record StatisticsHelper(
        LocalDate date,
        Long point
) {
}
