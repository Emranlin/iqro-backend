package com.example.iqro.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "find_couples")
public class FindCouple {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "find_couple_seq")
    @SequenceGenerator(name = "find_couple_gen", sequenceName = "find_couple_seq", allocationSize = 1)
    private Long id;
    private String arabicText;
    private String pronunciationText;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;
}