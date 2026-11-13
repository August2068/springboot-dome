package fr.simplon.domedespuys.dto;

import fr.simplon.domedespuys.service.interfaces.IProductService;
import fr.simplon.domedespuys.validation.ItemExist;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class PurchaseProductDTO {
    @Min(value = 1, message = "quantity doit être supérieur ou égal à 0")
    public int quantity;
    @Min(value = 1, message = "price doit être supérieur ou égal à 0")
    public Long price;
    @NotBlank(message = "product doit être renseigné")
    @ItemExist(serviceImpl = IProductService.class)
    public String productId;
}
