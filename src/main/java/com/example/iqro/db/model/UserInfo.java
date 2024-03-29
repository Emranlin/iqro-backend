package com.example.iqro.db.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    private int totalPoint;
    private int countOfTop3;
    private boolean emailConfirmed;
    private int confirmationCode;
    private LocalDateTime expirationTime;

    @ManyToMany(cascade = {PERSIST, MERGE, REFRESH, DETACH})
    @JoinTable(name = "user_info_lessons",
            joinColumns = @JoinColumn(name = "user_info_id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id"))
    private List<Lesson> lessons;

    @OneToOne(mappedBy = "userInfo", cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private User user;

    @OneToMany(mappedBy = "userInfo", cascade = ALL)
    private List<Result> results;
}