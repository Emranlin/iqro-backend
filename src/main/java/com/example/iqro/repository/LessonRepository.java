package com.example.iqro.repository;

import com.example.iqro.db.dto.response.lesson.ExampleResponse;
import com.example.iqro.db.dto.response.lesson.GetAllLessonResponse;
import com.example.iqro.db.dto.response.lesson.LessonResponse;
import com.example.iqro.db.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    @Query("SELECT NEW com.example.iqro.db.dto.response.lesson.GetAllLessonResponse(l.id,l.name)FROM Lesson l")
    List<GetAllLessonResponse> getAllLessons();

    @Query("SELECT NEW com.example.iqro.db.dto.response.lesson.LessonResponse(l.id, l.name, l.video, l.description, l.rule) " +
            "FROM Lesson l " +
            "WHERE l.id IN (SELECT ul.id FROM UserInfo ui " +
            "JOIN ui.lessons ul " +
            "WHERE ui.id = :userInfoId) AND l.id = :lessonId")
    Optional<LessonResponse> getByIdLesson(@Param("lessonId") Long lessonId, @Param("userInfoId") Long userInfoId);

    @Query("SELECT NEW com.example.iqro.db.dto.response.lesson.ExampleResponse(e.arabicText,e.audio)" +
            "FROM Example e " +
            "JOIN e.lesson l " +
            "WHERE l.id=:lessonId")
    List<ExampleResponse> getAllExamples(Long lessonId);


}