package com.example.iqro.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "qurans")
public class Quran {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "quran_gen")
    @SequenceGenerator(name = "quran_gen",sequenceName = "quran_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String surah;
    private String meaning;
    private String transcription;
    private String audio;
}