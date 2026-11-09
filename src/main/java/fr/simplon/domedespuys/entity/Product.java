package fr.simplon.domedespuys.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.ProductView;
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
    @JsonView(ProductView.Id.class)
    private Long id;
    @Column(nullable = false, length = 100)
    @JsonView(ProductView.Label.class)
    private String label;
    @Column(columnDefinition = "text")
    @JsonView(ProductView.Description.class)
    private String description;
    @Column(nullable = false)
    @JsonView(ProductView.Price.class)
    private Long price;
    @Column(nullable = false, length = 100)
    @JsonView(ProductView.Slug.class)
    private String slug;
    @Column(nullable = false, updatable = false)
    @JsonView(ProductView.CreatedAt.class)
    private LocalDateTime createdAt;
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    @JsonView(ProductView.Brand.class)
    private Brand brand;
    // j'ai du mettre en FetchType.EAGER pour faire les fixtures sinon erreur Cannot lazily initialize collectionwith key '116' no session
   //  @OneToMany(mappedBy = "product", orphanRemoval = true, fetch = FetchType.EAGER)
    // en mettant @Transactional sur run ça évite ce problème
    @OneToMany(mappedBy = "product", orphanRemoval = true)
    @JsonView(ProductView.Images.class)
    private List<Image> images;

    @JsonView(ProductView.MainImage.class)
    public Image getMainImage(){
        for (Image image: images){
            if(image.isDefault()){
                return image;
            }
        }
        return null;
    }
}
