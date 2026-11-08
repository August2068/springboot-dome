package fr.simplon.domedespuys.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String line;
    @Column(length = 50)
    private String extraLine;
    @Column(nullable = false, length = 50)
    private String city;
    @Column(nullable = false, length = 50)
    private String zipCode;
    @Column(nullable = false, length = 100)
    private String country;
    @Column(length = 50)
    private String phone;
    @Column(nullable = false, length = 50)
    private String firstname;
    @Column(nullable = false, length = 50)
    private String lastname;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private User user;
}
