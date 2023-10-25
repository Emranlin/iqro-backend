package com.example.iqro.service;

import com.example.iqro.db.dto.response.lesson.GetAllLessonResponse;
import com.example.iqro.db.dto.response.lesson.LessonResponse;

import java.util.List;

public interface LessonService {
    List<GetAllLessonResponse> getAllLessons();

    LessonResponse getById(Long lessonId);
}
