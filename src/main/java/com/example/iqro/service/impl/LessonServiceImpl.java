package com.example.iqro.service.impl;

import com.example.iqro.config.jwt.JwtService;
import com.example.iqro.db.dto.response.lesson.ExampleResponse;
import com.example.iqro.db.dto.response.lesson.GetAllLessonResponse;
import com.example.iqro.db.dto.response.lesson.LessonResponse;
import com.example.iqro.db.exceptions.NotFoundException;
import com.example.iqro.repository.LessonRepository;
import com.example.iqro.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final JwtService jwtService;

    @Override
    public List<GetAllLessonResponse> getAllLessons() {
        return lessonRepository.getAllLessons();
    }

    @Override
    public LessonResponse getById(Long lessonId) {
        Long userInfoId = jwtService.getAuthenticate().getUserInfo().getId();
        LessonResponse lessonResponse = lessonRepository.getByIdLesson(lessonId, userInfoId);
        List<ExampleResponse> examples = lessonRepository.getAllExamples(lessonId);
        lessonResponse.setExamples(examples);
        return lessonResponse;
    }
    }

