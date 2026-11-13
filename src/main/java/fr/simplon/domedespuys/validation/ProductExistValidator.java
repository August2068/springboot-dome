package fr.simplon.domedespuys.validation;

import fr.simplon.domedespuys.entity.Product;
import fr.simplon.domedespuys.service.ProductServiceImpl;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductExistValidator implements ConstraintValidator<ProductExist, String> {

    private ProductServiceImpl productService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return this.productService.getById(value)!=null;
    }
}
