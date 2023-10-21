package com.example.iqro.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "surahes")
public class Surah {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "surah_seq")
    @SequenceGenerator(name = "surah_gen", sequenceName = "surah_seq", allocationSize = 1)
    private Long id;
    private String arabicName;
    private String cyrillicName;
    private String audio;
    private String surah;
    private String meaning;
    private String transcription;
}