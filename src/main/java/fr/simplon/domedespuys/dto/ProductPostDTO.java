package fr.simplon.domedespuys.dto;

import fr.simplon.domedespuys.entity.Brand;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public class ProductPostDTO{
    @NotBlank(message = "label doit être renseigné")
    @Length(max = 100, message = "label ne peut pas faire plus de 100 charactères")
    public String label;
    public String description;
    @NotBlank(message = "price doit être renseigné")
    public Long price;
    @NotBlank(message = "brand doit être renseigné")
    public String brandId;
    public List<ImageDTO> images;
}
