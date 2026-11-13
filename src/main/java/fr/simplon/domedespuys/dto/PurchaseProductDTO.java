package fr.simplon.domedespuys.dto;

import fr.simplon.domedespuys.validation.ProductExist;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class PurchaseProductDTO {
    @NotBlank(message = "quantity doit être renseigné")
    @Min(value = 1, message = "quantity doit être supérieur ou égal à 0")
    public int quantity;
    @NotBlank(message = "price doit être renseigné")
    @Min(value = 1, message = "price doit être supérieur ou égal à 0")
    public Long price;
    @NotBlank(message = "product doit être renseigné")
    @ProductExist
    public String productId;
}
