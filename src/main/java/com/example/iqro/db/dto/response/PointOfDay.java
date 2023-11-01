package com.example.iqro.db.dto.response;

import java.time.DayOfWeek;

public record PointOfDay(
        DayOfWeek dayOfWeek,
        int point
) {
}
