package com.example.iqro.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "dua_categories")
public class DuaCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dua_category_seq")
    @SequenceGenerator(name = "dua_categories_gen",sequenceName = "dua_category_seq",allocationSize = 1)
    private Long id;
    private String name;
}