package com.example.iqro.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.CascadeType.ALL;

@Getter
@Setter
@Entity
@Table(name = "dua")
public class Dua {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dua_gen")
    @SequenceGenerator(name = "dua_gen", sequenceName = "dua_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String arabicText;
    private String transcription;
    private String meaning;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "dua_sub_category_id")
    private DuaSubCategory duaSubCategory;
}