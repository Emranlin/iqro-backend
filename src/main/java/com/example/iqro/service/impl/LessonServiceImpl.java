package com.example.iqro.service.impl;

import com.example.iqro.config.jwt.JwtService;
import com.example.iqro.db.dto.response.lesson.LessonGetAllResponse;
import com.example.iqro.db.dto.response.lesson.LessonResponse;
import com.example.iqro.db.dto.response.lesson.ModuleResponse;
import com.example.iqro.db.exceptions.BadRequestException;
import com.example.iqro.db.exceptions.NotFoundException;
import com.example.iqro.repository.LessonRepository;
import com.example.iqro.repository.ModuleRepository;
import com.example.iqro.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private final LessonRepository lessonRepository;
    private final JwtService jwtService;
    private final ModuleRepository moduleRepository;

    @Override
    public List<ModuleResponse> getAllModules() {
        return moduleRepository.getAllModules();
    }

    @Override
    public List<LessonGetAllResponse> getLessonsOfModule(Long moduleId) {
        Long userInfoId = jwtService.getAuthenticate().getUserInfo().getId();
        return lessonRepository.getLessonsOfModule(userInfoId, moduleId);
    }

    @Override
    public LessonResponse getLessonById(Long lessonId) {
        Long userInfoId = jwtService.getAuthenticate().getUserInfo().getId();

        LessonResponse lessonResponse = lessonRepository.getByIdLesson(lessonId, userInfoId).orElseThrow(
                () -> new NotFoundException("Урок с ID - %s не найден.".formatted(lessonId)));

        if (!lessonRepository.isAccessibleLesson(userInfoId, lessonId)) {
            throw new BadRequestException("Доступ закрыт");
        }

        lessonResponse.setExamples(lessonRepository.getAllExamples(lessonId));
        return lessonResponse;
    }

}

