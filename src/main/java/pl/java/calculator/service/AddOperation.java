package pl.java.calculator.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AddOperation implements CalculatorOperations {

    @Override
    public BigDecimal calculate(BigDecimal source, BigDecimal source2) {
        return source.add(source2);
    }

    @Override
    public String operator() {
        return "+";
    }

    @Override
    public String description() {
        return "Add two numbers and return result";
    }
}
