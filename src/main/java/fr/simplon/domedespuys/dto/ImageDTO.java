package fr.simplon.domedespuys.dto;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class ImageDTO {
    @NotBlank(message = "path doit être renseigné")
    @Length(max = 100, message = "path ne peut pas faire plus de 100 charactères")
    public String path;
    @NotBlank(message = "isDefault doit être renseigné")
    public boolean isDefault;
}
