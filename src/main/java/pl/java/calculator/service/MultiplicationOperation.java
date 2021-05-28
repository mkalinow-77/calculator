package pl.java.calculator.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class MultiplicationOperation implements CalculatorOperations {

    @Override
    public BigDecimal calculate(BigDecimal source, BigDecimal source2) {
        return source.multiply(source2);
    }

    @Override
    public String operator() {
        return "*";
    }

    @Override
    public String description() {
        return "Multiply two numbers and return result";
    }
}