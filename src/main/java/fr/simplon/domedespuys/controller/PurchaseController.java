package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.entity.Purchase;
import fr.simplon.domedespuys.repository.PurchaseRepository;
import fr.simplon.domedespuys.view.PurchaseView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
    private final PurchaseRepository purchaseRepository;

    @GetMapping
    @JsonView(PurchaseView.PurchaseViewList.class)
    public List<Purchase> getPurchases(){
        return purchaseRepository.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(PurchaseView.PurchaseDetail.class)
    public Optional<Purchase> getPurchaseById(@PathVariable String id){
        return purchaseRepository.findById(Long.valueOf(id));
    }
}
