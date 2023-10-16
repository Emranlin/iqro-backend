package com.example.iqro.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@Table(name = "modules")
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "module_gen")
    @SequenceGenerator(name = "module_gen", sequenceName = "module_seq", allocationSize = 1)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "module", cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private List<Lesson> lessons;
}