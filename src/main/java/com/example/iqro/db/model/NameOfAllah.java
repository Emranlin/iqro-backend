package com.example.iqro.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "names_of_allah")
public class NameOfAllah {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "name_of_allah_gen")
    @SequenceGenerator(name = "name_of_allah_gen", sequenceName = "name_of_allah_seq", allocationSize = 1)
    private Long id;
    private String arabicName;
    private String cyrillicName;
    private String meaning;
    private String audio;
}