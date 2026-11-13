package fr.simplon.domedespuys.validation;

import fr.simplon.domedespuys.entity.Product;
import fr.simplon.domedespuys.service.interfaces.IGetItem;
import fr.simplon.domedespuys.service.interfaces.IProductService;
import jakarta.persistence.EntityManager;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ItemExistValidator implements ConstraintValidator<ItemExist, String> {

    private IGetItem<?> service;
    private final BeanFactory beans;

    @Autowired
    ItemExistValidator (BeanFactory beans){
        this.beans = beans;
    }

    @Override
    public void initialize(ItemExist constraintAnnotation) {
        this.service = beans.getBean(constraintAnnotation.serviceImpl());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value == null){
            return false;
        }
        return service.getById(value)!=null;
    }
}
