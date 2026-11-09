package fr.simplon.domedespuys.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.ImageView;
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
    @JsonView(ImageView.Id.class)
    private Long id;
    @Column(nullable = false, length = 100)
    @JsonView(ImageView.Path.class)
    private String path;
    @Column(nullable = false, length = 10)
    @JsonView(ImageView.Extension.class)
    private String extension;
    @Column(nullable = false)
    @JsonView(ImageView.IsDefault.class)
    private boolean isDefault;
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    @JsonView(ImageView.Product.class)
    private Product product;
}
