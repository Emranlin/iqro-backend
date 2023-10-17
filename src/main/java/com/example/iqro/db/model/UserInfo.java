package com.example.iqro.db.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@Table(name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_gen")
    @SequenceGenerator(name = "user_info_gen", sequenceName = "user_info_seq", allocationSize = 1, initialValue = 7)
    private Long id;
    private String name;
    private String phoneNumber;
    private String avatar;
    private LocalDate registerDate;

    @OneToOne(cascade = ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    @JoinTable(name = "user_info_lessons",
            joinColumns = @JoinColumn(name = "user_info_id"),
            inverseJoinColumns = @JoinColumn(name = "lessons_id"))
    private List<Lesson> lessons;
}