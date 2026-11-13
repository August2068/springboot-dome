package fr.simplon.domedespuys.validation;

import fr.simplon.domedespuys.service.interfaces.IGetItem;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ItemExistValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ItemExist {
    Class<? extends IGetItem<?>> serviceImpl();
    String message() default "donnée incorrecte";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
