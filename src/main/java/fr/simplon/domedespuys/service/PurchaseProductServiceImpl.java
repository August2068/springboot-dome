package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.PurchaseProductDTO;
import fr.simplon.domedespuys.entity.Purchase;
import fr.simplon.domedespuys.entity.PurchaseProduct;
import fr.simplon.domedespuys.repository.PurchaseProductRepository;
import fr.simplon.domedespuys.service.interfaces.IPurchaseProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PurchaseProductServiceImpl implements IPurchaseProductService {

    private PurchaseProductRepository purchaseProductRepository;

    @Override
    public PurchaseProduct createPurchaseProduct(Purchase purchase, PurchaseProductDTO purchaseProductDTO) {
        return null;
    }
}
