package com.example.iqro.db.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "question_gen")
    @SequenceGenerator(name = "question_gen", sequenceName = "question_seq", allocationSize = 1)
    private Long id;
    private String question;

    @ManyToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    @JoinColumn(name = "test_id")
    private Test test;
}