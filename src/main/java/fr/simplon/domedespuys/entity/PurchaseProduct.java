package fr.simplon.domedespuys.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.PurchaseProductsView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(PurchaseProductsView.Id.class)
    private Long id;
    @Column(nullable = false)
    @JsonView(PurchaseProductsView.Quantity.class)
    private int quantity;
    @Column(nullable = false)
    @JsonView(PurchaseProductsView.Price.class)
    private Long price;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    @JsonView(PurchaseProductsView.Purchase.class)
    private Purchase purchase;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    @JsonView(PurchaseProductsView.Product.class)
    private Product product;
}
