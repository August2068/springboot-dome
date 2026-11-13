package fr.simplon.domedespuys.dto;

import fr.simplon.domedespuys.entity.EnumPurchaseStatus;
import fr.simplon.domedespuys.validation.ValueOfEnum;
import jakarta.validation.constraints.NotBlank;

public class PurchasePutDTO {
    @NotBlank(message = "status doit être renseigné")
    @ValueOfEnum(enumClass = EnumPurchaseStatus.class)
    public String status;
}
