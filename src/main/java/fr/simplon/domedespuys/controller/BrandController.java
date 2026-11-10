package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.dto.BrandDTO;
import fr.simplon.domedespuys.entity.Brand;
import fr.simplon.domedespuys.service.interfaces.IBrandService;
import fr.simplon.domedespuys.view.BrandView;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
// Rest => appelle le serializer jackson pour retourner du json
// Controller pour que ce soit injectable et que springboot sache ou redigirer les reqêtes http
@RestController
@RequestMapping("/api/brand")
public class BrandController {

    private final IBrandService brandService;

    @GetMapping
    @JsonView(BrandView.BrandListView.class)
    public List<Brand> getBrands(){
        return brandService.getCollection();
    }

  /*  @GetMapping("/slug/{slug}")
    @JsonView(BrandView.BrandDetailView.class)
    public Optional<Brand> getBrandBySlug(@PathVariable String slug){
        return brandRepository.findBySlug(slug);
    }*/
    // getBrandBySlug saute on n'en a pas besoin, je conserve juste pour le commentaire du dessous
    // mettre /slug/{slug} avant /{id} comme ça il essaye pas de prendre /slug/{slug} en id et si on a pas /slug dans la route alors il regarde id

    @GetMapping("/{id}")
    @JsonView(BrandView.BrandDetailView.class)
    public Brand getBrandById(@PathVariable String id){
        return brandService.getById(id);
    }

    @PostMapping
    @JsonView(BrandView.BrandDetailView.class)
    public Brand createBrand(@RequestBody BrandDTO dto){
        return brandService.create(dto);
    }

    @PutMapping("/{id}")
    @JsonView(BrandView.BrandDetailView.class)
    public Brand updateBrand(@PathVariable String id, @RequestBody BrandDTO dto){
        return brandService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public boolean deleteBrand(@PathVariable String id){
        return brandService.delete(id);
    }
}
