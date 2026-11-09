package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.entity.Product;
import fr.simplon.domedespuys.repository.ProductRepository;
import fr.simplon.domedespuys.view.ProductView;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    @JsonView(ProductView.ProductListView.class)
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/all")
    @JsonView(ProductView.ProductListView.class)
    public Page<Product> getProductsPagination(
            @PageableDefault(
                    size = 10, // nb Element par page
                    sort = { "label" }, // order by
                    direction = Sort.Direction.DESC
            ) Pageable pageable
    ){
        return productRepository.findAll(pageable);
    }

    @GetMapping("/label/{label}")
    @JsonView(ProductView.ProductListView.class)
    public List<Product> getProductsSearch(@PathVariable String label){
        return productRepository.findWhereLabelLike(label);
    }

    @GetMapping("/slug/{slug}")
    @JsonView(ProductView.ProductDetailView.class)
    public Optional<Product> getProductBySlug(@PathVariable String slug){
        return productRepository.findBySlug(slug);
    }

    @GetMapping("/{id}")
    @JsonView(ProductView.ProductDetailView.class)
    public Optional<Product> getProductById(@PathVariable String id){
        return productRepository.findById(Long.valueOf(id));
    }
    // faire en sorte qu'il ne renvoie pas de 500 si {id} n'est pas un long
}
