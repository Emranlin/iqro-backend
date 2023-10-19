package com.example.iqro.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@Table(name = "find_couples")
public class FindCouple {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "find_couple_gen")
    @SequenceGenerator(name = "find_couple_gen", allocationSize = 1)
    private Long id;
    private String arabicText;
    private String pronunciationText;

    @ManyToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    @JoinColumn(name = "question_id")
    private Question question;
}