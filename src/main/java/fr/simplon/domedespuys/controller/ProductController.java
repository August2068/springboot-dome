package fr.simplon.domedespuys.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.dto.ProductPostDTO;
import fr.simplon.domedespuys.dto.ProductPutDTO;
import fr.simplon.domedespuys.entity.Product;
import fr.simplon.domedespuys.service.interfaces.IProductService;
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

    private final IProductService productService;

    @GetMapping
    @JsonView(ProductView.ProductListView.class)
    public List<Product> getProducts(){
        return productService.getCollection();
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
        return productService.getCollectionPage(pageable);
    }

    @GetMapping("/label/{label}")
    @JsonView(ProductView.ProductListView.class)
    public List<Product> getProductsSearch(@PathVariable String label){
        return productService.getProductWhereLabelLike(label);
    }

    @GetMapping("/{id}")
    @JsonView(ProductView.ProductDetailView.class)
    public Product getProductById(@PathVariable String id){
        return productService.getById(id);
    }
    // faire en sorte qu'il ne renvoie pas de 500 si {id} n'est pas un long

    @PostMapping
    @JsonView(ProductView.ProductPostView.class)
    public Product createProduct(@RequestBody ProductPostDTO dto){ return productService.create(dto);}

    @PutMapping("/{id}")
    @JsonView(ProductView.ProductDetailView.class)
    public Product updateProduct(@PathVariable String id, @RequestBody ProductPutDTO dto){ return productService.update(id, dto);}

}
