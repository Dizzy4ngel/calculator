package org.example;

import org.example.exceptions.DivisionByZeroException;
import org.example.exceptions.InvalidCalculatorInputException;
import org.example.exceptions.InvalidCalculatorTypeException;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.lang.String.valueOf;

public class Calculator implements Validator{

    @Override
    public void validate(Map<InputType, String> input) {
        //Todo
        validateOperator(input.get(InputType.OPERATOR));
        validateNumberInput(input.get(InputType.A));
        validateNumberInput(input.get(InputType.B));
    }

    protected double calculate(Map<InputType, String> input){
        Double a = Double.valueOf(input.get(InputType.A));
        double b = Double.parseDouble(input.get(InputType.B));
        String operator = input.get(InputType.OPERATOR);
        switch (operator){
            case "+" -> {
                return a + b;
            }
            case "-" -> {
                return a - b;
            }
            case "*" -> {
                return a * b;
            }
            case "/" -> {
                if (b == 0) {
                    throw new DivisionByZeroException();
                }
                return a / b;
            }
            default -> throw new RuntimeException("Unexpected error occurred");
        }
    }

    public void validateNumberInput(String stringNumber){
        try{
            Integer.parseInt(stringNumber);
        } catch (NumberFormatException e){
            throw new InvalidCalculatorInputException();
        }
    }
    //Todo
    private void validateOperator(String stringOperator){
        if ((!((String)stringOperator == "+"))
                && (!((String)stringOperator == "-"))
                &&  (!((String)stringOperator == "*"))
                && (!((String)stringOperator == "/"))) {
            if((String)stringOperator == "$")
                //|| ((String)stringOperator == "#"){
                throw new InvalidCalculatorTypeException();
            }
            throw new InvalidCalculatorInputException();
        }
    }
