package com.example.iqro.service;

import com.example.iqro.db.dto.response.lesson.LessonGetAllResponse;
import com.example.iqro.db.dto.response.lesson.LessonResponse;
import com.example.iqro.db.dto.response.lesson.ModuleResponse;

import java.util.List;

public interface LessonService {
    List<ModuleResponse> getAllModules();

    List<LessonGetAllResponse> getLessonsOfModule(Long moduleId);

    LessonResponse getLessonById(Long lessonId);

}
