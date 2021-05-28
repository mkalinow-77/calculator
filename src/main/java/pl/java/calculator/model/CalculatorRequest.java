package pl.java.calculator.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.java.calculator.error.ValidOperation;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculatorRequest {

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal firstNumber;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal secondNumber;
    @ValidOperation
    private String operator;


}
