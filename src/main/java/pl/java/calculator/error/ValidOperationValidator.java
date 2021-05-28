package pl.java.calculator.error;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.java.calculator.service.CalculatorOperations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ValidOperationValidator implements ConstraintValidator<ValidOperation, String> {

    private final Set<CalculatorOperations> allOperations;

    @Override
    public boolean isValid(String operator, ConstraintValidatorContext constraintValidatorContext) {
        return allOperations.stream().anyMatch(a -> a.operator().equals(operator));
    }
}