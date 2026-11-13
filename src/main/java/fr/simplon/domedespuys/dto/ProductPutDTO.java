package fr.simplon.domedespuys.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public class ProductPutDTO {
    @NotBlank(message = "label doit être renseigné")
    @Length(max = 100, message = "label ne peut pas faire plus de 100 charactères")
    public String label;
    public String description;
    @NotBlank(message = "price doit être renseigné")
    public Long price;
    @Valid
    public List<ImageDTO> images;
}
