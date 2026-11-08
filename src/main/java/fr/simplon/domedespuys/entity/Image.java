package fr.simplon.domedespuys.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String path;
    @Column(nullable = false, length = 10)
    private String extension;
    @Column(nullable = false)
    private boolean isDefault;
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Product product;
}
