package com.example.iqro.db.dto.response.lesson;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class LessonResponse{
    private  Long lessonId;
    private String name;
    private String video;
   private String description;
   private String rule;
   private List<ExampleResponse> examples;

    public LessonResponse(Long lessonId, String name, String video, String description, String rule) {
        this.lessonId = lessonId;
        this.name = name;
        this.video = video;
        this.description = description;
        this.rule = rule;
    }
}

