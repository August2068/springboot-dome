package fr.simplon.domedespuys.dto;

import fr.simplon.domedespuys.entity.Brand;
import fr.simplon.domedespuys.service.interfaces.IBrandService;
import fr.simplon.domedespuys.validation.ItemExist;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public class ProductPostDTO{
    @NotBlank(message = "label doit être renseigné")
    @Length(max = 100, message = "label ne peut pas faire plus de 100 charactères")
    public String label;
    public String description;
    @Min(value = 1, message = "price doit être supérieur ou égal à 1")
    public Long price;
    @ItemExist(serviceImpl = IBrandService.class)
    public String brandId;
    @Valid
    public List<ImageDTO> images;
}
