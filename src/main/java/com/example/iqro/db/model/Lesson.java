package com.example.iqro.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lesson_gen")
    @SequenceGenerator(name = "lesson_gen", sequenceName = "lesson_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String video;

    @OneToMany(mappedBy = "lesson", cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private List<Test> tests;

    @OneToMany(mappedBy = "lesson", cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private List<FindCouple> findCouples;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "module_id")
    private Module module;

    @ManyToMany(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    @JoinTable(name = "lessons_users",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = @JoinColumn(name = "users_id"))
    private List<User> users;
}