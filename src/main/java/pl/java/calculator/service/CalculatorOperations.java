package pl.java.calculator.service;

import java.math.BigDecimal;

public interface CalculatorOperations {

    BigDecimal calculate(BigDecimal source, BigDecimal source2);

    String operator();

    String description();
}
