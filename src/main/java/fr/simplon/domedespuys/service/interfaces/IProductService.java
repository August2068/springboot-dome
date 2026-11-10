package fr.simplon.domedespuys.service.interfaces;

import fr.simplon.domedespuys.dto.ProductPostDTO;
import fr.simplon.domedespuys.dto.ProductPutDTO;
import fr.simplon.domedespuys.entity.Product;

public interface IProductService extends
        IGetItem<Product>,
        ICollection<Product>,
        ICreate<Product, ProductPostDTO>,
        IUpdate<Product, ProductPutDTO>
{
}
