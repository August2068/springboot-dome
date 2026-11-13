package fr.simplon.domedespuys.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class ValueOfEnumValidator implements ConstraintValidator<ValueOfEnum, CharSequence> {
    private List<String> acceptedValues;

    @Override
    public void initialize(ValueOfEnum constraintAnnotation) {
        acceptedValues = Arrays.stream(constraintAnnotation.enumClass().getEnumConstants()).map(Enum::name).collect(Collectors.toUnmodifiableList());
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        return acceptedValues.contains(value.toString());
    }
}
