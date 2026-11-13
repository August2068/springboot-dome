package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.exception.InvalidAddressException;
import fr.simplon.domedespuys.dto.PurchasePostDTO;
import fr.simplon.domedespuys.dto.PurchaseProductDTO;
import fr.simplon.domedespuys.dto.PurchasePutDTO;
import fr.simplon.domedespuys.entity.Address;
import fr.simplon.domedespuys.entity.EnumPurchaseStatus;
import fr.simplon.domedespuys.entity.Purchase;
import fr.simplon.domedespuys.entity.User;
import fr.simplon.domedespuys.repository.PurchaseRepository;
import fr.simplon.domedespuys.service.interfaces.IAddressService;
import fr.simplon.domedespuys.service.interfaces.IPurchaseProductService;
import fr.simplon.domedespuys.service.interfaces.IPurchaseService;
import fr.simplon.domedespuys.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PurchaseServiceImpl implements IPurchaseService {

    private PurchaseRepository purchaseRepository;
    private IUserService userService;
    private IAddressService addressService;
    private IPurchaseProductService purchaseProductService;

    @Override
    public List<Purchase> getCollection() {
        return purchaseRepository.findAll();
    }

    @Override
    public Purchase create(PurchasePostDTO dto) {
        Purchase purchase = new Purchase();
        User user = userService.getById("1");
        purchase.setUser(user);
        purchase.setStatus(EnumPurchaseStatus.PENDING.getValue());
        Address address = addressService.getById(dto.addressId);
        purchase.setAddress(address);
        if(address == null){
            throw new InvalidAddressException("adresse invalide");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("P");
        stringBuilder.append(LocalDateTime.now().getYear());
        stringBuilder.append(user.getId());
        stringBuilder.append(UUID.randomUUID());
        purchase.setNumber(stringBuilder.toString().replace("-","").substring(0,19));
        purchaseRepository.saveAndFlush(purchase);
        for(PurchaseProductDTO purchaseProductDTO : dto.purchaseProducts){
            purchaseProductService.createPurchaseProduct(purchase, purchaseProductDTO);
        }
        purchaseProductService.flush();
        return purchase;
    }

    @Override
    public Purchase getById(String id) {
        return purchaseRepository.findById(Long.parseLong(id)).orElse(null);
    }

    @Override
    public Purchase update(String id, PurchasePutDTO dto) {
        Purchase purchase = getById(id);
        if(purchase!= null){
            purchase.setStatus(EnumPurchaseStatus.valueOf(dto.status).getValue());
            purchaseRepository.saveAndFlush(purchase);
        }
        return purchase;
    }
}
