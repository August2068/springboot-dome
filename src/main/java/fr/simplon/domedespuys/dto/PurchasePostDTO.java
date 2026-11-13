package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class PurchasePostDTO {
    @NotBlank(message = "addresse doit être renseigné")
    public String addressId;
    public List<PurchaseProductDTO> purchaseProducts;
}
