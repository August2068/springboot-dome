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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String label;
    @Column(columnDefinition = "text")
    private String description;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = false, length = 100)
    private String slug;
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Brand brand;
    // j'ai du mettre en FetchType.EAGER pour faire les fixtures sinon erreur Cannot lazily initialize collectionwith key '116' no session
   //  @OneToMany(mappedBy = "product", orphanRemoval = true, fetch = FetchType.EAGER)
    @OneToMany(mappedBy = "product", orphanRemoval = true)
    private List<Image> images;
}
