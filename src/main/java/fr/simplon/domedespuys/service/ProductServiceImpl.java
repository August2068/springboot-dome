package fr.simplon.domedespuys.service;

import fr.simplon.domedespuys.dto.ImageDTO;
import fr.simplon.domedespuys.dto.ProductPostDTO;
import fr.simplon.domedespuys.dto.ProductPutDTO;
import fr.simplon.domedespuys.entity.Product;
import fr.simplon.domedespuys.repository.ProductRepository;
import fr.simplon.domedespuys.service.interfaces.IBrandService;
import fr.simplon.domedespuys.service.interfaces.IImageService;
import fr.simplon.domedespuys.service.interfaces.IProductService;
import fr.simplon.domedespuys.utils.Slugger;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements IProductService {

    private ProductRepository productRepository;
    private IBrandService brandService;
    private IImageService imageService;
    private Slugger slugger;

    @Override
    public List<Product> getCollection() {
        return productRepository.findAll();
    }

    @Override
    public Product create(ProductPostDTO dto) {
        Product product = new Product();
        dtoToObject(dto, product);
        for(ImageDTO image : dto.images){
            imageService.create(image, product);
        }
        imageService.flush();
        return null;
    }

    @Override
    public Product getById(String id) {
        return productRepository.findById(Long.parseLong(id)).orElse(null);
    }

    @Override
    public Product update(String id, ProductPutDTO dto) {
        return null;
    }

    @Override
    public Page<Product> getCollectionPage(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public List<Product> getProductWhereLabelLike(String label) {
        return productRepository.findWhereLabelLike(label);
    }

    private void dtoToObject(ProductPutDTO dto, Product product){
        product.setLabel(dto.label);
        product.setDescription(dto.description);
        product.setPrice(dto.price);
        product.setSlug(slugger.slugify(dto.label));
        if(dto instanceof ProductPostDTO){
            product.setCreatedAt(LocalDateTime.now());
            product.setBrand(brandService.getById(((ProductPostDTO) dto).brandId));
        }
        productRepository.saveAndFlush(product);
    }
}
