package pl.java.calculator.controller;

import org.springframework.web.bind.annotation.*;
import pl.java.calculator.model.CalculatorRequest;
import pl.java.calculator.model.CalculatorResponse;
import pl.java.calculator.service.CalculatorOperations;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class CalculatorController {

    private final Map<String, CalculatorOperations> calculate;

    public CalculatorController(Set<CalculatorOperations> allOperations){
        this.calculate = allOperations.stream().collect(Collectors.toMap(CalculatorOperations::operator, Function.identity()));
    }

    @GetMapping("/operations")
    public List<CalculatorResponse> getAllOperations() {
        return calculate.values().stream()
                .map(calc -> CalculatorResponse.builder()
                        .description(calc.description())
                        .build()).collect(Collectors.toList());
    }

    @PostMapping("/calculate")
    public BigDecimal calculate(@RequestBody @Valid CalculatorRequest request){
        return calculate.get(request.getOperator()).calculate(request.getFirstNumber(), request.getSecondNumber());
    }
}