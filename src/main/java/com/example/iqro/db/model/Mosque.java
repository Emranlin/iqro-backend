package com.example.iqro.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mosques")
public class Mosque {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mosque_gen")
    @SequenceGenerator(name = "mosque_gen", sequenceName = "mosque_seq", allocationSize = 1)
    private Long id;
    private String name;
    private String address;
}