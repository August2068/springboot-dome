package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.dto.PurchasePostDTO;
import fr.simplon.domedespuys.dto.PurchasePutDTO;
import fr.simplon.domedespuys.entity.Purchase;
import fr.simplon.domedespuys.service.interfaces.IPurchaseProductService;
import fr.simplon.domedespuys.service.interfaces.IPurchaseService;
import fr.simplon.domedespuys.view.PurchaseView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
    private final IPurchaseService purchaseService;

    @GetMapping
    @JsonView(PurchaseView.PurchaseViewList.class)
    public List<Purchase> getPurchases(){
        return
        purchaseService.getCollection();
    }

    @GetMapping("/{id}")
    @JsonView(PurchaseView.PurchaseDetail.class)
    public Purchase getPurchaseById(@PathVariable String id){
        return purchaseService.getById(id);
    }

    @PostMapping
    @JsonView(PurchaseView.PurchaseDetail.class)
    public Purchase createPurchase(@RequestBody PurchasePostDTO dto){ return purchaseService.create(dto);}

    @PutMapping("/{id}")
    @JsonView(PurchaseView.PurchaseDetail.class)
    public Purchase updatePurchase(@PathVariable String id, @RequestBody PurchasePutDTO dto){ return purchaseService.update(id, dto);}
}

