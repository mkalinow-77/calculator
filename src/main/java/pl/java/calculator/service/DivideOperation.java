package pl.java.calculator.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DivideOperation implements CalculatorOperations {

    @Override
    public BigDecimal calculate(BigDecimal source, BigDecimal source2) {
        return source.divide(source2);
    }

    @Override
    public String operator() {
        return "/";
    }

    @Override
    public String description() {
        return "Divide two numbers and return result";
    }
}
