package fr.simplon.domedespuys.entity;

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
    private Long id;

    @Column(unique = true, length = 20, nullable = false)
    private String number;

    @Column(nullable = false, length = 10)
    private String status = EnumPurchaseStatus.PENDING.getValue();
    // valeur par défaut

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Address address;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseProduct> purchaseProducts;
}
