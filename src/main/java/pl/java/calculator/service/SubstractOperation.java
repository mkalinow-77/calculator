package pl.java.calculator.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class SubstractOperation implements CalculatorOperations {

    @Override
    public BigDecimal calculate(BigDecimal source, BigDecimal source2) {
        return source.subtract(source2);
    }

    @Override
    public String operator() {
        return "-";
    }

    @Override
    public String description() {
        return "Substract two numbers and return result";
    }
}
