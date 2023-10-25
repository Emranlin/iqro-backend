package com.example.iqro.api;

import com.example.iqro.db.dto.response.lesson.GetAllLessonResponse;
import com.example.iqro.db.dto.response.lesson.LessonResponse;
import com.example.iqro.service.LessonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lesson")
@RequiredArgsConstructor
@Tag(name = "Lesson API")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LessonController {
    private final LessonService lessonService;

    @Operation(summary = "Get all lessons", description = "this method will get all lessons")
    @GetMapping
    public List<GetAllLessonResponse> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @Operation(summary = "Get by id Lesson", description = "this method will get by id lesson")
    @GetMapping("/{lessonId}")
    public LessonResponse getById(@PathVariable Long lessonId) {
        return lessonService.getById(lessonId);
    }
}
