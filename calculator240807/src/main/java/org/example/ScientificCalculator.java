package org.example;

import org.example.exceptions.InvalidCalculatorTypeException;

import java.util.Map;

public class ScientificCalculator extends Calculator {

    @Override
    public void validate(Map<InputType, String> input){
        try {
            super.validate(input);
        } catch (InvalidCalculatorTypeException ignored){
        }
    }

    @Override
    public double calculate(Map<InputType, String> input){
        Double a = Double.valueOf(input.get(InputType.A)); //igy is lehet
        double b = Double.parseDouble(input.get(InputType.B));
        String operator = input.get(InputType.OPERATOR);

        switch (operator){
            case "$" -> {
                return Math.pow(a, b);
            }
            case "#" -> {
                return Math.pow(a, 1 / b);
            }
            default -> {
                return super.calculate(input);
            }
        }
    }
}
