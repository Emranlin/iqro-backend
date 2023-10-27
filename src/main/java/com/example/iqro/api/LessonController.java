package com.example.iqro.api;

import com.example.iqro.db.dto.response.lesson.LessonGetAllResponse;
import com.example.iqro.db.dto.response.lesson.LessonResponse;
import com.example.iqro.db.dto.response.lesson.ModuleResponse;
import com.example.iqro.service.LessonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/iqro")
@RequiredArgsConstructor
@Tag(name = "Lesson API")
@CrossOrigin(origins = "*", maxAge = 3600)
@PreAuthorize("hasAuthority('USER')")
public class LessonController {
    private final LessonService lessonService;


    @Operation(summary = "Get all module", description = "This method will get all module")
    @GetMapping("/modules")
    public List<ModuleResponse> getAllModules() {
        return lessonService.getAllModules();
    }

    @Operation(summary = "Get all lessons of module", description = "This method will get all lessons by module id")
    @GetMapping("/lessons")
    public List<LessonGetAllResponse> getLessonsOfModule(@RequestParam Long moduleId) {
        return lessonService.getLessonsOfModule(moduleId);
    }

    @Operation(summary = "Get by id Lesson", description = "This method will get by id lesson")
    @GetMapping("/lessons/{lessonId}")
    public LessonResponse getLessonById(@PathVariable Long lessonId) {
        return lessonService.getLessonById(lessonId);
    }
}
