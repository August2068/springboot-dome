package fr.simplon.domedespuys.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.BrandView;
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
    @JsonView(BrandView.Id.class)
    private Long id;
    @Column(nullable = false, length = 50)
    @JsonView(BrandView.Label.class)
    private String label;
    @Column(columnDefinition = "TEXT")
    @JsonView(BrandView.Logo.class)
    private String logo;
    @Column(nullable = false, length = 50)
    @JsonView(BrandView.Slug.class)
    private String slug;
    @OneToMany(mappedBy = "brand", orphanRemoval = true)
    @JsonView(BrandView.Products.class)
    private List<Product> products;
}
