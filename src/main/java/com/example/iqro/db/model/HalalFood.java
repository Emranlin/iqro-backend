package com.example.iqro.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "halal_foods")
public class HalalFood {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "halal_food_gen")
    @SequenceGenerator(name = "halal_food_gen", sequenceName = "halal_food_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String location;
    private String image;
}