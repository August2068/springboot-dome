package fr.simplon.domedespuys.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ProductExistValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductExist {
    String message() default "ce produit n'existe pas";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
