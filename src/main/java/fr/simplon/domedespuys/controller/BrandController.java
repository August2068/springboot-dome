package fr.simplon.domedespuys.controller;

import fr.simplon.domedespuys.entity.Brand;
import fr.simplon.domedespuys.repository.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/brand")
public class BrandController {

    private final BrandRepository brandRepository;

    @GetMapping
    public List<Brand> getBrands(){
        return brandRepository.findAll();
    }

    @GetMapping("/slug/{slug}")
    public Optional<Brand> getBrandBySlug(@PathVariable String slug){
        return brandRepository.findBySlug(slug);
    }
    // mettre /slug/{slug} avant /{id} comme ça il essaye pas de prendre /slug/{slug} en id et si on a pas /slug dans la route alors il regarde id
    @GetMapping("/{id}")
    public Optional<Brand> getBrandById(@PathVariable String id){
        return brandRepository.findById(Long.valueOf(id));
    }

}
