package fr.simplon.domedespuys.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.PurchaseView;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
// @Data fait getter / setter / et redefinit le toString
@Entity
@Table(name = "purchase")
// pour redéfinir le nom de la table dans le cas où le nom par défaut poserais problèmes
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(PurchaseView.Id.class)
    private Long id;

    @Column(unique = true, length = 20, nullable = false)
    @JsonView(PurchaseView.Number.class)
    private String number;

    @Column(nullable = false, length = 10)
    @JsonView(PurchaseView.Status.class)
    private String status = EnumPurchaseStatus.PENDING.getValue();
    // valeur par défaut

    @Column(nullable = false, updatable = false)
    @JsonView(PurchaseView.CreatedAt.class)
    private LocalDateTime createdAt;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    @JsonView(PurchaseView.User.class)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    @JsonView(PurchaseView.Address.class)
    private Address address;

    @OneToMany(mappedBy = "purchase")
    @JsonView(PurchaseView.PurchaseProducts.class)
    private List<PurchaseProduct> purchaseProducts;
}
