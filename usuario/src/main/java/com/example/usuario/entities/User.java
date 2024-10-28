package com.example.usuario.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private String username;
    private String firstName;
    private String lastName;
    @Column(nullable = false)
    private String password;
    private String phone;

    @Enumerated(EnumType.STRING)
    private UserStatus status;
}
