package fr.simplon.domedespuys.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, length = 128)
    private String password;
    @Column(nullable = false, length = 50)
    private String firstname;
    @Column(nullable = false, length = 50)
    private String lastname;
    @Column(length = 50)
    private String phone;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<Address> addresses;
    @OneToMany(mappedBy = "user")
    private List<Purchase> purchases;
}

