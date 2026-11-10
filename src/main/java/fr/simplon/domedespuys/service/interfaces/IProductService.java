package fr.simplon.domedespuys.service.interfaces;

import fr.simplon.domedespuys.dto.ProductPostDTO;
import fr.simplon.domedespuys.dto.ProductPutDTO;
import fr.simplon.domedespuys.entity.Product;

import java.util.List;

public interface IProductService extends
        IGetItem<Product>,
        ICollection<Product>,
        ICreate<Product, ProductPostDTO>,
        IUpdate<Product, ProductPutDTO>,
        ICollectionPage<Product>
{
    List<Product> getProductWhereLabelLike(String label);
}
