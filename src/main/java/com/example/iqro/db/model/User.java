package com.example.iqro.db.model;

import com.example.iqro.db.model.enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1, initialValue = 7)
    private Long id;
    private String name;
    private String phoneNumber;
    private String avatar;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private LocalDate registerDate;
    private boolean emailConfirmed;
    private int confirmationCode;
    @ManyToMany(mappedBy = "users", cascade = {PERSIST, MERGE, REFRESH, DETACH})
    private List<Lesson> lessons;
}