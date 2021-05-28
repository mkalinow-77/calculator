package pl.java.calculator.error;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidOperationValidator.class)
public @interface ValidOperation {

    String message() default "Unknown operation";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
