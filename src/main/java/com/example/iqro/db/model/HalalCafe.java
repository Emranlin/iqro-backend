package com.example.iqro.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "halal_cafes")
public class HalalCafe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "halal_cafe_gen")
    @SequenceGenerator(name = "halal_cafe_gen",sequenceName = "halal_cafe_seq",allocationSize = 1)
    private Long id;
    private String name;
    private String coordinate;
}