package fr.simplon.domedespuys.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String label;
    @Column(columnDefinition = "TEXT")
    private String logo;
    @Column(nullable = false, length = 50)
    private String slug;
    @OneToMany(mappedBy = "brand", orphanRemoval = true)
    private List<Product> products;
}
