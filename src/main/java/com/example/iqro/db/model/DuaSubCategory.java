package com.example.iqro.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Getter
@Setter
@Entity
@Table(name = "dua_sub_categories")
public class DuaSubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dua_sub_categories_gen")
    @SequenceGenerator(name = "dua_sub_categories_gen", sequenceName = "dua_sub_category_seq", allocationSize = 1)
    private Long id;
    private String name;

    @OneToMany(cascade = ALL)
    private List<DuaCategory> duaCategories;
}