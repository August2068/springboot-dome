package fr.simplon.domedespuys.dto;

import fr.simplon.domedespuys.service.interfaces.IAddressService;
import fr.simplon.domedespuys.validation.ItemExist;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public class PurchasePostDTO {
    @ItemExist(serviceImpl = IAddressService.class)
    public String addressId;
    @Valid
    public List<PurchaseProductDTO> purchaseProducts;
}
