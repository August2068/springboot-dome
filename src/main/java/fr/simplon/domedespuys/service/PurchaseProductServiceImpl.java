package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.PurchaseProductDTO;
import fr.simplon.domedespuys.entity.Purchase;
import fr.simplon.domedespuys.entity.PurchaseProduct;
import fr.simplon.domedespuys.repository.PurchaseProductRepository;
import fr.simplon.domedespuys.service.interfaces.IProductService;
import fr.simplon.domedespuys.service.interfaces.IPurchaseProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PurchaseProductServiceImpl implements IPurchaseProductService {

    private PurchaseProductRepository purchaseProductRepository;
    private IProductService productService;

    @Override
    public PurchaseProduct createPurchaseProduct(Purchase purchase, PurchaseProductDTO dto) {
        PurchaseProduct purchaseProduct = new PurchaseProduct();
        purchaseProduct.setProduct(productService.getById(dto.productId));
        purchaseProduct.setPrice(dto.price);
        purchaseProduct.setQuantity(dto.quantity);
        purchaseProduct.setPurchase(purchase);
        purchaseProductRepository.save(purchaseProduct);
        return purchaseProduct;
    }

    @Override
    public void flush() {
        purchaseProductRepository.flush();
    }
}
