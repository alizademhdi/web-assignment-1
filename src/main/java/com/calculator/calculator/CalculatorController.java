package com.calculator.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CalculatorController {
    @GetMapping("/calc/mult/{op1}/{op2}")
    public String multiply(@PathVariable int op1, @PathVariable int op2) {
        double result = op1 * op2;
        return this.formatter(op1, op2, result, "*");
    }

    @GetMapping("/calc/div/{op1}/{op2}")
    public String divide(@PathVariable int op1, @PathVariable int op2) {
        if (op2 == 0) {
            return "Cannot divide by zero!";
        }
        double result = (double) op1 / op2;
        return this.formatter(op1, op2, result, "/");
    }

    @GetMapping("/calc/subtract/{op1}/{op2}")
    public String subtract(@PathVariable int op1, @PathVariable int op2) {
        double result = op1 - op2;
        return this.formatter(op1, op2, result, "-");
    }

    @GetMapping("/calc/sum/{op1}/{op2}")
    public String sum(@PathVariable int op1, @PathVariable int op2) {
        double result = op1 + op2;
        return this.formatter(op1, op2, result, "+");
    }

    public String formatter(int op1, int op2, double result, String operator){
        return String.valueOf(op1) + operator + String.valueOf(op2) + "=" + String.valueOf(result);
    }
}
