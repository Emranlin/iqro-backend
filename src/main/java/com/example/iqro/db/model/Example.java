package com.example.iqro.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "examples")
public class Example {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "example_gen")
    @SequenceGenerator(name = "example_gen", sequenceName = "example_seq", allocationSize = 1)
    private Long id;
    private String arabicText;
    private String audio;
    @ManyToOne()
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
}