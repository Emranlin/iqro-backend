package com.example.iqro.db.model;

import com.example.iqro.db.model.enums.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;


@Getter
@Setter
@Entity
@Table(name = "tests")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_gen")
    @SequenceGenerator(name = "test_gen", sequenceName = "test_seq", allocationSize = 1)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Type type;
    private String video;

    @OneToMany(mappedBy = "test", cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private List<Question> questions;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
}