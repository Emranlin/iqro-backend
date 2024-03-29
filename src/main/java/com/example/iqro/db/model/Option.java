package com.example.iqro.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@Table(name = "options")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "option_gen")
    @SequenceGenerator(name = "option_gen", sequenceName = "option_seq", allocationSize = 1)
    private Long id;
    private String option;
    private Boolean isTrue;

    @ManyToOne(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    @JoinColumn(name = "question_id")
    private Question question;
}