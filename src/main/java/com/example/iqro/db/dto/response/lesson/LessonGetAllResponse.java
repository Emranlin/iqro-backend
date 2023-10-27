package com.example.iqro.db.dto.response.lesson;

public record LessonGetAllResponse(
        Long lessonId,
        String name,
        boolean accessible
) {
}
