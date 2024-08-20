package org.example;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = CalculatorFactory.getCalculator(UserInteractionHandler.getType());

        Map<InputType, String> input = UserInteractionHandler.getInput();

        calculator.validate(input);

        System.out.println(calculator.calculate(input));

    }
}