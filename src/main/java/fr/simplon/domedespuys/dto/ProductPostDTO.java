package fr.simplon.domedespuys.dto;

import fr.simplon.domedespuys.entity.Brand;

import java.util.List;

public class ProductPostDTO extends ProductPutDTO{
    public String label;
    public String description;
    public Long price;
    public String brandId;
    public List<ImageDTO> images;
}
